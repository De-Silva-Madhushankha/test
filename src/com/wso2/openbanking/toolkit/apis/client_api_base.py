# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.client_process_request_body import ClientProcessRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_client_process import Response200ForClientProcess
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseClientApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseClientApi.subclasses = BaseClientApi.subclasses + (cls,)
    async def pre_process_client_creation_post(
        self,
        client_process_request_body: ClientProcessRequestBody,
    ) -> Response200ForClientProcess:
        ...


    async def pre_process_client_update_post(
        self,
        client_process_request_body: ClientProcessRequestBody,
    ) -> Response200ForClientProcess:
        ...


    async def pre_process_client_retrieval_post(
        self,
        client_process_request_body: ClientProcessRequestBody,
    ) -> Response200ForClientProcess:
        ...
