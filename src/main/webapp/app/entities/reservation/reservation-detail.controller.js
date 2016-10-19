(function() {
    'use strict';

    angular
        .module('bibliothequeApp')
        .controller('ReservationDetailController', ReservationDetailController);

    ReservationDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Reservation', 'Usager', 'Oeuvre'];

    function ReservationDetailController($scope, $rootScope, $stateParams, previousState, entity, Reservation, Usager, Oeuvre) {
        var vm = this;

        vm.reservation = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibliothequeApp:reservationUpdate', function(event, result) {
            vm.reservation = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
