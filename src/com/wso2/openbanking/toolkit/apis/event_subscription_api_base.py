# coding: utf-8

from typing import ClassVar, Dict, List, Tuple  # noqa: F401

from com.wso2.openbanking.toolkit.models.error_response import ErrorResponse
from com.wso2.openbanking.toolkit.models.event_subscription_request_body import EventSubscriptionRequestBody
from com.wso2.openbanking.toolkit.models.response200_for_enrich_event_subscription import Response200ForEnrichEventSubscription
from com.wso2.openbanking.toolkit.models.response200_for_event_subscription_validation import Response200ForEventSubscriptionValidation
from com.wso2.openbanking.toolkit.security_api import get_token_OAuth2, get_token_BasicAuth

class BaseEventSubscriptionApi:
    subclasses: ClassVar[Tuple] = ()

    def __init_subclass__(cls, **kwargs):
        super().__init_subclass__(**kwargs)
        BaseEventSubscriptionApi.subclasses = BaseEventSubscriptionApi.subclasses + (cls,)
    async def validate_event_subscription_post(
        self,
        event_subscription_request_body: EventSubscriptionRequestBody,
    ) -> Response200ForEventSubscriptionValidation:
        ...


    async def enrich_event_subscription_response_post(
        self,
        event_subscription_request_body: EventSubscriptionRequestBody,
    ) -> Response200ForEnrichEventSubscription:
        ...
