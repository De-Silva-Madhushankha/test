# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.event_polling_request_body import EventPollingRequestBody
from com.wso2.openbanking.toolkit.models.response200_for_enrich_event_polling import Response200ForEnrichEventPolling
from com.wso2.openbanking.toolkit.models.response200_for_event_validation import Response200ForEventValidation
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseEventPollingApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseEventPollingApi.subclasses = BaseEventPollingApi.subclasses + (cls,)
    async def validate_event_polling_post(
        self,
        event_polling_request_body: EventPollingRequestBody,
    ) -> Response200ForEventValidation:
        ...


    async def enrich_event_polling_response_post(
        self,
        event_polling_request_body: EventPollingRequestBody,
    ) -> Response200ForEnrichEventPolling:
        ...
