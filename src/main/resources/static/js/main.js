(function() {
  'use strict';

  // two way data binding (to UI)
  var vm = new Vue({
    el: '#app',

  	//`methods` オブジェクトの下にメソッドを定義する
  	methods: {
  	regist: function (event) {
      //新規登録画面を開く
    	window.location.href = "regist"
    	}
  	}
  });
})();