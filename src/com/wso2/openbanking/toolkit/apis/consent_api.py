# coding: utf-8

from typing import Dict, List  # noqa: F401
import importlib
import pkgutil

from com.wso2.openbanking.toolkit.apis.consent_api_base import BaseConsentApi
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
from typing import Optional
from com.wso2.openbanking.toolkit.models.enrich_consent_creation_request_body import EnrichConsentCreationRequestBody
from com.wso2.openbanking.toolkit.models.enrich_consent_search_request_body import EnrichConsentSearchRequestBody
from com.wso2.openbanking.toolkit.models.enrich_file_upload_response_request_body import EnrichFileUploadResponseRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.persist_authorized_consent_request_body import PersistAuthorizedConsentRequestBody
from com.wso2.openbanking.toolkit.models.populate_consent_authorize_screen_request_body import PopulateConsentAuthorizeScreenRequestBody
from com.wso2.openbanking.toolkit.models.pre_process_consent_creation_request_body import PreProcessConsentCreationRequestBody
from com.wso2.openbanking.toolkit.models.pre_process_consent_request_body import PreProcessConsentRequestBody
from com.wso2.openbanking.toolkit.models.pre_process_file_upload_request_body import PreProcessFileUploadRequestBody
from com.wso2.openbanking.toolkit.models.response200 import Response200
from com.wso2.openbanking.toolkit.models.response200_for_consent_revocation import Response200ForConsentRevocation
from com.wso2.openbanking.toolkit.models.response200_for_consent_search import Response200ForConsentSearch
from com.wso2.openbanking.toolkit.models.response200_for_persist_authorized_consent import Response200ForPersistAuthorizedConsent
from com.wso2.openbanking.toolkit.models.response200_for_populate_consent_authorize_screen import Response200ForPopulateConsentAuthorizeScreen
from com.wso2.openbanking.toolkit.models.response200_for_pre_process_consent_creation import Response200ForPreProcessConsentCreation
from com.wso2.openbanking.toolkit.models.response200_for_pre_process_file_upload import Response200ForPreProcessFileUpload
from com.wso2.openbanking.toolkit.models.response200_for_response_alternation import Response200ForResponseAlternation
from com.wso2.openbanking.toolkit.models.validate_consent_access_request_body import ValidateConsentAccessRequestBody
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

router = APIRouter()

ns_pkg = com.wso2.openbanking.toolkit.impl
for _, name, _ in pkgutil.iter_modules(ns_pkg.__path__, ns_pkg.__name__ + "."):
    importlib.import_module(name)


@router.post(
    "/pre-process-consent-creation",
    responses={
        200: {"model": Response200ForPreProcessConsentCreation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle pre validations &amp; obtain custom consent data to be stored",
    response_model_by_alias=True,
)
async def pre_process_consent_creation_post(
    pre_process_consent_creation_request_body: PreProcessConsentCreationRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForPreProcessConsentCreation:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().pre_process_consent_creation_post(pre_process_consent_creation_request_body)


@router.post(
    "/enrich-consent-creation-response",
    responses={
        200: {"model": Response200ForResponseAlternation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle post-consent generation -response generation,validations",
    response_model_by_alias=True,
)
async def enrich_consent_creation_response_post(
    enrich_consent_creation_request_body: EnrichConsentCreationRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForResponseAlternation:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().enrich_consent_creation_response_post(enrich_consent_creation_request_body)


@router.post(
    "/pre-process-consent-file-upload",
    responses={
        200: {"model": Response200ForPreProcessFileUpload, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="Handle pre validations related to file upload requests.",
    response_model_by_alias=True,
)
async def pre_process_consent_file_upload_post(
    pre_process_file_upload_request_body: PreProcessFileUploadRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForPreProcessFileUpload:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().pre_process_consent_file_upload_post(pre_process_file_upload_request_body)


@router.post(
    "/enrich-consent-file-response",
    responses={
        200: {"model": Response200ForResponseAlternation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="Modify the response sent in the file upload request after successfully storing the file.",
    response_model_by_alias=True,
)
async def enrich_consent_file_response_post(
    enrich_file_upload_response_request_body: EnrichFileUploadResponseRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForResponseAlternation:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().enrich_consent_file_response_post(enrich_file_upload_response_request_body)


@router.post(
    "/pre-process-consent-retrieval",
    responses={
        200: {"model": Response200ForResponseAlternation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle pre-consent retrieval validations",
    response_model_by_alias=True,
)
async def pre_process_consent_retrieval_post(
    pre_process_consent_request_body: PreProcessConsentRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForResponseAlternation:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().pre_process_consent_retrieval_post(pre_process_consent_request_body)


@router.post(
    "/validate-consent-file-retrieval",
    responses={
        200: {"model": Response200, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="Handle validations related to file retrieval and return a response",
    response_model_by_alias=True,
)
async def validate_consent_file_retrieval_post(
    pre_process_consent_request_body: PreProcessConsentRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().validate_consent_file_retrieval_post(pre_process_consent_request_body)


@router.post(
    "/pre-process-consent-revoke",
    responses={
        200: {"model": Response200ForConsentRevocation, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle pre-consent revocation validations when a TPP calls consent /DELETE",
    response_model_by_alias=True,
)
async def pre_process_consent_revoke_post(
    pre_process_consent_request_body: PreProcessConsentRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForConsentRevocation:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().pre_process_consent_revoke_post(pre_process_consent_request_body)


@router.post(
    "/enrich-consent-search-response",
    responses={
        200: {"model": Response200ForConsentSearch, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle consent search required extension to fetch additional data",
    response_model_by_alias=True,
)
async def enrich_consent_search_response_post(
    enrich_consent_search_request_body: EnrichConsentSearchRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForConsentSearch:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().enrich_consent_search_response_post(enrich_consent_search_request_body)


@router.post(
    "/populate-consent-authorize-screen",
    responses={
        200: {"model": Response200ForPopulateConsentAuthorizeScreen, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle validations before consent  authorization and consent data to load in consent authorization UI",
    response_model_by_alias=True,
)
async def populate_consent_authorize_screen_post(
    populate_consent_authorize_screen_request_body: Optional[PopulateConsentAuthorizeScreenRequestBody] = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForPopulateConsentAuthorizeScreen:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().populate_consent_authorize_screen_post(populate_consent_authorize_screen_request_body)


@router.post(
    "/persist-authorized-consent",
    responses={
        200: {"model": Response200ForPersistAuthorizedConsent, "description": "Successful response"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle consent persistence logic and enrich response with user authorization and account mapping data",
    response_model_by_alias=True,
)
async def persist_authorized_consent_post(
    persist_authorized_consent_request_body: PersistAuthorizedConsentRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200ForPersistAuthorizedConsent:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().persist_authorized_consent_post(persist_authorized_consent_request_body)


@router.post(
    "/validate-consent-access",
    responses={
        200: {"model": Response200, "description": "Ok"},
        400: {"model": ErrorResponse, "description": "Bad Request"},
        500: {"model": ErrorResponse, "description": "Server Error"},
    },
    tags=["Consent"],
    summary="handle custom consent data validations before data access",
    response_model_by_alias=True,
)
async def validate_consent_access_post(
    validate_consent_access_request_body: ValidateConsentAccessRequestBody = Body(None, description=""),
    token_OAuth2: TokenModel = Security(
        get_token_OAuth2, scopes=[]
    ),
    token_BasicAuth: TokenModel = Security(
        get_token_BasicAuth
    ),
) -> Response200:
    if not BaseConsentApi.subclasses:
        raise HTTPException(status_code=500, detail="Not implemented")
    return await BaseConsentApi.subclasses[0]().validate_consent_access_post(validate_consent_access_request_body)
