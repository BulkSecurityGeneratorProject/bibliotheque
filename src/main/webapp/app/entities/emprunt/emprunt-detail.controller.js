(function() {
    'use strict';

    angular
        .module('bibliothequeApp')
        .controller('EmpruntDetailController', EmpruntDetailController);

    EmpruntDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Emprunt', 'Usager', 'Exemplaire'];

    function EmpruntDetailController($scope, $rootScope, $stateParams, previousState, entity, Emprunt, Usager, Exemplaire) {
        var vm = this;

        vm.emprunt = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('bibliothequeApp:empruntUpdate', function(event, result) {
            vm.emprunt = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
