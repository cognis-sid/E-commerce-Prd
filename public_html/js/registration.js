$(document).ready(function () {
  var current_fs, next_fs, previous_fs;

  // No BACK button on first screen
  if ($(".show").hasClass("first-screen")) {
    $(".prev").css({ display: "none" });
  }

 

  // Previous button
  $(".prev").click(function () {
    current_fs = $(".show");
    previous_fs = $(".show").prev();

    $(current_fs).removeClass("show");
    $(previous_fs).addClass("show");

    $(".prev").css({ display: "block" });

    if ($(".show").hasClass("first-screen")) {
      $(".prev").css({ display: "none" });
    }

    $("#progressbar li")
      .eq($(".card2").index(current_fs))
      .removeClass("active");
    $(".progressbar-menu").eq($(".card2").index(current_fs)).removeClass("progressbar-menu-active");

    current_fs.animate(
      {},
      {
        step: function () {
          current_fs.css({
            display: "none",
            position: "relative",
          });

          previous_fs.css({
            display: "block",
          });
        },
      }
    );
  });
});
