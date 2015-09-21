'use strict';

angular.module('bluepillbingoApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


