# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.application_api_base import BaseApplicationApi
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
from com.wso2.openbanking.toolkit.models.app_create_process_request_body import AppCreateProcessRequestBody
from com.wso2.openbanking.toolkit.models.app_update_process_request_body import AppUpdateProcessRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_application_creation import Response200ForApplicationCreation
from com.wso2.openbanking.toolkit.models.response200_for_application_update import Response200ForApplicationUpdate
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/pre-process-application-creation",
    responses={
        200: {"model": Response200ForApplicationCreation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Application"],
    summary="handle pre validations &amp; changes to the consumer application creation",
    response_model_by_alias=True,
)
async def pre_process_application_creation_post(
    app_create_process_request_body: AppCreateProcessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForApplicationCreation:
    if not BaseApplicationApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseApplicationApi.subclasses[0]().pre_process_application_creation_post(app_create_process_request_body)


@router.post(
    "/pre-process-application-update",
    responses={
        200: {"model": Response200ForApplicationUpdate, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Application"],
    summary="handle pre validations &amp; changes to the consumer application update",
    response_model_by_alias=True,
)
async def pre_process_application_update_post(
    app_update_process_request_body: AppUpdateProcessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForApplicationUpdate:
    if not BaseApplicationApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseApplicationApi.subclasses[0]().pre_process_application_update_post(app_update_process_request_body)
