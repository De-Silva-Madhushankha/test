# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.app_create_process_request_body import AppCreateProcessRequestBody
from com.wso2.openbanking.toolkit.models.app_update_process_request_body import AppUpdateProcessRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_application_creation import Response200ForApplicationCreation
from com.wso2.openbanking.toolkit.models.response200_for_application_update import Response200ForApplicationUpdate
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseApplicationApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseApplicationApi.subclasses = BaseApplicationApi.subclasses + (cls,)
    async def pre_process_application_creation_post(
        self,
        app_create_process_request_body: AppCreateProcessRequestBody,
    ) -> Response200ForApplicationCreation:
        ...


    async def pre_process_application_update_post(
        self,
        app_update_process_request_body: AppUpdateProcessRequestBody,
    ) -> Response200ForApplicationUpdate:
        ...
