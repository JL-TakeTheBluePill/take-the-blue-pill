 'use strict';

angular.module('bluepillbingoApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-bluepillbingoApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-bluepillbingoApp-params')});
                }
                return response;
            },
        };
    });