/*
 * 自定义AngularJS的模板和路由；
 */

// 定义模块 actionApp, 并依赖于路由模板 ngRout
var actionApp = angular.module('actionApp', ['ngRoute']);
angular.module('ng').filter('tel', function (){});

actionApp.config(['$routeProvider', function ($routeProvider) {

    /*
    * /oper 为路由名称
    * controller 路由的控制器名称
    * templateUrl 定义的是视图地址
    * */

    $routeProvider.when('/oper', {
        controller: 'View1Controller',
        templateUrl: 'views/view1.html',
    }).when('/directive', {
        controller: 'View2Controller',
        templateUrl: 'views/view2.html',
    });

}]);