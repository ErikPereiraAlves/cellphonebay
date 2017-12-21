var app = angular.module('cellphonebay',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: '<a class="vglnk" href="http://localhost:8080/cellphonebay" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>cellphonebay</span></a>',
    PRODUCT_SERVICE_API : '<a class="vglnk" href="http://localhost:8080/cellphonebay/product/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>cellphonebay</span><span>/</span><span>Product</span><span>/</span></a>'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'product/list',
                controller:'ProductController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all products');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);