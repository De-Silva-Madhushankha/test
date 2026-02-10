# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_mapper_request_body import ErrorMapperRequestBody
from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_error_mapper import Response200ForErrorMapper
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseErrorHandlingApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseErrorHandlingApi.subclasses = BaseErrorHandlingApi.subclasses + (cls,)
    async def map_accelerator_error_response_post(
        self,
        error_mapper_request_body: ErrorMapperRequestBody,
    ) -> Response200ForErrorMapper:
        ...
