# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

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

class BaseConsentApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseConsentApi.subclasses = BaseConsentApi.subclasses + (cls,)
    async def pre_process_consent_creation_post(
        self,
        pre_process_consent_creation_request_body: PreProcessConsentCreationRequestBody,
    ) -> Response200ForPreProcessConsentCreation:
        ...


    async def enrich_consent_creation_response_post(
        self,
        enrich_consent_creation_request_body: EnrichConsentCreationRequestBody,
    ) -> Response200ForResponseAlternation:
        ...


    async def pre_process_consent_file_upload_post(
        self,
        pre_process_file_upload_request_body: PreProcessFileUploadRequestBody,
    ) -> Response200ForPreProcessFileUpload:
        ...


    async def enrich_consent_file_response_post(
        self,
        enrich_file_upload_response_request_body: EnrichFileUploadResponseRequestBody,
    ) -> Response200ForResponseAlternation:
        ...


    async def pre_process_consent_retrieval_post(
        self,
        pre_process_consent_request_body: PreProcessConsentRequestBody,
    ) -> Response200ForResponseAlternation:
        ...


    async def validate_consent_file_retrieval_post(
        self,
        pre_process_consent_request_body: PreProcessConsentRequestBody,
    ) -> Response200:
        ...


    async def pre_process_consent_revoke_post(
        self,
        pre_process_consent_request_body: PreProcessConsentRequestBody,
    ) -> Response200ForConsentRevocation:
        ...


    async def enrich_consent_search_response_post(
        self,
        enrich_consent_search_request_body: EnrichConsentSearchRequestBody,
    ) -> Response200ForConsentSearch:
        ...


    async def populate_consent_authorize_screen_post(
        self,
        populate_consent_authorize_screen_request_body: Optional[PopulateConsentAuthorizeScreenRequestBody],
    ) -> Response200ForPopulateConsentAuthorizeScreen:
        ...


    async def persist_authorized_consent_post(
        self,
        persist_authorized_consent_request_body: PersistAuthorizedConsentRequestBody,
    ) -> Response200ForPersistAuthorizedConsent:
        ...


    async def validate_consent_access_post(
        self,
        validate_consent_access_request_body: ValidateConsentAccessRequestBody,
    ) -> Response200:
        ...
