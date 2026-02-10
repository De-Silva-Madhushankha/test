# coding: utf-8

from typing import List

from fastapi import Depends, Security  # noqa: F401
from fastapi.openapi.models import OAuthFlowImplicit, OAuthFlows  # noqa: F401
from fastapi.security import (  # noqa: F401
    HTTPAuthorizationCredentials,
    HTTPBasic,
    HTTPBasicCredentials,
    HTTPBearer,
    OAuth2,
    OAuth2AuthorizationCodeBearer,
    OAuth2PasswordBearer,
    SecurityScopes,
)
from fastapi.security.api_key import APIKeyCookie, APIKeyHeader, APIKeyQuery  # noqa: F401

from com.wso2.openbanking.toolkit.models.extra_models import TokenModel


basic_auth = HTTPBasic()


def get_token_BasicAuth(
    credentials: HTTPBasicCredentials = Depends(basic_auth)
) -> TokenModel:
    """
    Check and retrieve authentication information from basic auth.

    :param credentials Credentials provided by Authorization header
    :type credentials: HTTPBasicCredentials
    :rtype: TokenModel | None
    """

    ...



def get_token_OAuth2(
    security_scopes: SecurityScopes, token: str = Depends(oauth2_)
) -> TokenModel:
    """
    Validate and decode token.

    :param token Token provided by Authorization header
    :type token: str
    :return: Decoded token information or None if token is invalid
    :rtype: TokenModel | None
    """

    ...


def validate_scope_OAuth2(
    required_scopes: SecurityScopes, token_scopes: List[str]
) -> bool:
    """
    Validate required scopes are included in token scope

    :param required_scopes Required scope to access called API
    :type required_scopes: List[str]
    :param token_scopes Scope present in token
    :type token_scopes: List[str]
    :return: True if access to called API is allowed
    :rtype: bool
    """

    return False

