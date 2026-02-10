# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.event_polling_api_base import BaseEventPollingApi
import com.wso2.openbanking.toolkit.impl

from fastapi import (  # noqa: F401
    APIRouter,
    Body,
    Cookie,
    Depends,
    Form,
    Header,
    HTTPException,
    Path,
    Query,
    Response,
    Security,
    status,
)

from com.wso2.openbanking.toolkit.models.extra_models import TokenModel  # noqa: F401
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.event_polling_request_body import EventPollingRequestBody
from com.wso2.openbanking.toolkit.models.response200_for_enrich_event_polling import Response200ForEnrichEventPolling
from com.wso2.openbanking.toolkit.models.response200_for_event_validation import Response200ForEventValidation
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/validate-event-polling",
    responses={
        200: {"model": Response200ForEventValidation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Event Polling"],
    summary="handle event polling validations &amp; storing data",
    response_model_by_alias=True,
)
async def validate_event_polling_post(
    event_polling_request_body: EventPollingRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForEventValidation:
    if not BaseEventPollingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseEventPollingApi.subclasses[0]().validate_event_polling_post(event_polling_request_body)


@router.post(
    "/enrich-event-polling-response",
    responses={
        200: {"model": Response200ForEnrichEventPolling, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Event Polling"],
    summary="handle post event-polling response generation",
    response_model_by_alias=True,
)
async def enrich_event_polling_response_post(
    event_polling_request_body: EventPollingRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForEnrichEventPolling:
    if not BaseEventPollingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseEventPollingApi.subclasses[0]().enrich_event_polling_response_post(event_polling_request_body)
