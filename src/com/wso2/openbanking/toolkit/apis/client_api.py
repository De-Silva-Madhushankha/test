# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.client_api_base import BaseClientApi
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
from com.wso2.openbanking.toolkit.models.client_process_request_body import ClientProcessRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_client_process import Response200ForClientProcess
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/pre-process-client-creation",
    responses={
        200: {"model": Response200ForClientProcess, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Client"],
    summary="handle pre validations &amp; obtain custom data to store in dynamic client registration step",
    response_model_by_alias=True,
)
async def pre_process_client_creation_post(
    client_process_request_body: ClientProcessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForClientProcess:
    if not BaseClientApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseClientApi.subclasses[0]().pre_process_client_creation_post(client_process_request_body)


@router.post(
    "/pre-process-client-update",
    responses={
        200: {"model": Response200ForClientProcess, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Client"],
    summary="handle pre validations &amp; obtain  custom data to store in dynamic client update step",
    response_model_by_alias=True,
)
async def pre_process_client_update_post(
    client_process_request_body: ClientProcessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForClientProcess:
    if not BaseClientApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseClientApi.subclasses[0]().pre_process_client_update_post(client_process_request_body)


@router.post(
    "/pre-process-client-retrieval",
    responses={
        200: {"model": Response200ForClientProcess, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Client"],
    summary="handle post client retrieval response generation",
    response_model_by_alias=True,
)
async def pre_process_client_retrieval_post(
    client_process_request_body: ClientProcessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForClientProcess:
    if not BaseClientApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseClientApi.subclasses[0]().pre_process_client_retrieval_post(client_process_request_body)
