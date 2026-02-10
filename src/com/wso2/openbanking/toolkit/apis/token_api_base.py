# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.issue_refresh_token_request_body import IssueRefreshTokenRequestBody
from com.wso2.openbanking.toolkit.models.response200_for_issue_refresh_token import Response200ForIssueRefreshToken
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseTokenApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseTokenApi.subclasses = BaseTokenApi.subclasses + (cls,)
    async def issue_refresh_token_post(
        self,
        issue_refresh_token_request_body: IssueRefreshTokenRequestBody,
    ) -> Response200ForIssueRefreshToken:
        ...
