# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.response200_for_validate_authorization_request import Response200ForValidateAuthorizationRequest
from com.wso2.openbanking.toolkit.models.validate_authorization_request_body import ValidateAuthorizationRequestBody
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseAuthorizeApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseAuthorizeApi.subclasses = BaseAuthorizeApi.subclasses + (cls,)
    async def pre_user_authorization(
        self,
        validate_authorization_request_body: ValidateAuthorizationRequestBody,
    ) -> Response200ForValidateAuthorizationRequest:
        ...
