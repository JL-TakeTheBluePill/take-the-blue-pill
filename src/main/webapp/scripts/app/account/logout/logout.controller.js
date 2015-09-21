'use strict';

angular.module('bluepillbingoApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
