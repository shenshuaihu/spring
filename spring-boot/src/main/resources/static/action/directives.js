// 自定义指令

// 定义一个指令名为 datePicker
actionApp.directive('datePicker', function () {
    return {
        restrict: 'AC', //
        link: function (scope, elem, attrs) {
            elem.datepicker();
        }
    }
})