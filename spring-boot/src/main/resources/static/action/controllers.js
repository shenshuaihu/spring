// 自定义控制器

actionApp.controller('View1Controller', ['$rootScope', "$scope", '$http',
    function ($rootScope, $scope, $http) {

    // 监听事件 $scope.$on 监听 $viewContentLoaded 事件 是页面加载之后执行的操作
        $scope.$on('$viewContentLoaded', function () {
            console.log('页面加载完成');
        });

        // 核心代码
        /**
         * 在scope内定义的 search 方法， 在页面上通过ng-click 调用
         *
         */
        $scope.search = function () {
            // 获取页面定义的 ng-model = 'personName' 的值
            personName = $scope.personName;
            // 向服务器地址search发送get请求
            $http.get('search', {
                // params 请求参数
                params: {personName: personName}
            }).success(function (data) {
                // 回调 回去服务器上的值 页面上边可以用{{person.name}} 直接使用
                $scope.person = data;
            })
        };

}]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',
    function ($rootScope, $scope) {
       $scope.$on('$viewContentLoaded', function () {
           console.log('页面加载完成');
       });

}]);