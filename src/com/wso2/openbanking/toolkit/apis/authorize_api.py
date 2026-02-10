# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.authorize_api_base import BaseAuthorizeApi
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
from com.wso2.openbanking.toolkit.models.response200_for_validate_authorization_request import Response200ForValidateAuthorizationRequest
from com.wso2.openbanking.toolkit.models.validate_authorization_request_body import ValidateAuthorizationRequestBody
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/validate-authorization-request",
    responses={
        200: {"model": Response200ForValidateAuthorizationRequest, "description": "Successful response"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Authorize"],
    summary="Handles pre-user authorization requests",
    response_model_by_alias=True,
)
async def pre_user_authorization(
    validate_authorization_request_body: ValidateAuthorizationRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForValidateAuthorizationRequest:
    if not BaseAuthorizeApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseAuthorizeApi.subclasses[0]().pre_user_authorization(validate_authorization_request_body)
