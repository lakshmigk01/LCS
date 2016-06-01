// Code goes here

(function() {

	var app = angular.module("lcsViewer", []);

	var LCSController = function($scope, $http) {

		var onLCSComplete = function(response) {
			$scope.lcs = response.data;
		};

		var onError = function(reason) {
			$scope.error = "Could not fetch the lcs";
		};

		$http.get("http://localhost:8080/api/v1/lcs").then(onLCSComplete,
				onError);

		

	};

	app.controller("LCSController", [ "$scope", "$http", LCSController ]);

}());