'use strict';

angular.module('bluepillbingoApp')
    .factory('BingoGame', function ($rootScope, $http) {
        return {
            game: function () {
                return $http.get('api/bingo/game');
            },
            draw: function () {
                return $http.get('api/bingo/draw');
            }
        }
    });
