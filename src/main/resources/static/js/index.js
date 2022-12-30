function button_click(value) {
      var target = document.getElementById("searchLink");
      if (value == 0) {
        target.href = "http://google.co.jp";
        target.innerText = "サイトへのリンク (google)";
      }
      else if (value == 1) {
        target.href = "http://yahoo.co.jp";
        target.innerText = "サイトへのリンク (Yahoo)";
      }
    }