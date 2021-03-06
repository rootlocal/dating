package com.greetim

/**
 * Put current user profile to request
 */
class ContextFilters {
    AccountService accountService;
    ProfileService profileService;

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                def account = accountService.current();
                request.setAttribute(DatingUtils.CURRENT_ACCOUNT_ATTR_NAME, account);
                if(account){
                    request.setAttribute(DatingUtils.CURRENT_PROFILE_ATTR_NAME, profileService.findByAccount(account));
                }
            }
        }
    }
}