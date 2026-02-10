# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.event_creation_request_body import EventCreationRequestBody
from com.wso2.openbanking.toolkit.models.response200_for_event_validation import Response200ForEventValidation
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseEventCreationApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseEventCreationApi.subclasses = BaseEventCreationApi.subclasses + (cls,)
    async def validate_event_creation_post(
        self,
        event_creation_request_body: EventCreationRequestBody,
    ) -> Response200ForEventValidation:
        ...
