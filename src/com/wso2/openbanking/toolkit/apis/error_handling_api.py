# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.error_handling_api_base import BaseErrorHandlingApi
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
from com.wso2.openbanking.toolkit.models.error_mapper_request_body import ErrorMapperRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_error_mapper import Response200ForErrorMapper
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/map-accelerator-error-response",
    responses={
        200: {"model": Response200ForErrorMapper, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Error Handling"],
    summary="map accelerator level error formats to custom error formats",
    response_model_by_alias=True,
)
async def map_accelerator_error_response_post(
    error_mapper_request_body: ErrorMapperRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForErrorMapper:
    if not BaseErrorHandlingApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseErrorHandlingApi.subclasses[0]().map_accelerator_error_response_post(error_mapper_request_body)
