'use strict';

angular.module('bluepillbingoApp')
    .factory('BingoGame', function ($rootScope, $http) {
        return {
            game: function (searchTerm) {
                if (!searchTerm)
                    searchTerm = "blue";

                return $http.get('api/bingo/game?searchTerm='+searchTerm);
            },
            draw: function () {
                return $http.get('api/bingo/draw');
            },
            checkForFullHouse: function(checkedProductIds) {
                var csvProductIds = "";

                for (var i=0; i<checkedProductIds.length; i++) {
                    if (csvProductIds)
                        csvProductIds += ",";

                    csvProductIds += checkedProductIds[i];
                }

                return $http.get("api/bingo/checkForFullHouse?id="+csvProductIds);
            }
        }
    });
