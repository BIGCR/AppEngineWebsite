/**
 * Created by CXR0963 on 12/1/2014.
 */
(function($) {
    $.fn.customLibrary = function(){
        alert_enable_java();
    };

    alert_enable_java = function(){
        console("Alerted!!");
    }

}(jQuery));