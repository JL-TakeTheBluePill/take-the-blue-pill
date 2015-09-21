'use strict';

angular.module('bluepillbingoApp')
    .factory('BingoGame', function ($rootScope, $http) {
        return {
            game: function () {
                return $http.get('api/bingo/game').then(function (response) {
                    return response.data;
                });
            },
            draw: function () {
                return $http.get('api/bingo/draw').then(function (response) {
                    return response.data;
                });
            }
        }
    });
