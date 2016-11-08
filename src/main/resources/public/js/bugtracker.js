/**
 * Created by gschuell on 11/7/16.
 */
angular.module('bugtracker', [])
    .controller('home', function($http) {
        var self = this;
        $http.get('bugtracker:8080/issues/allissues').then(function(response) {
            self.greeting = response.data;
        })
    });