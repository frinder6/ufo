package ufo.framework;

/**
 * Created by frinder_liu on 2016/8/16.
 */
public class Test {

    public static void main(String[] args) {

        String iconsStr = "bt-icon-alt,icon-window-delete,icon-download,icon-home,icon-calendar,icon-folder-add,icon-windows,icon-volume,icon-speaker,icon-star,icon-sun,icon-trash,icon-zoom,icon-user-outline,icon-picture,icon-phone,icon-newspaper,icon-printer,icon-microwave,icon-refresh,icon-lock,icon-email,icon-browser,icon-bubble,icon-calculator,icon-cd,icon-enter,icon-file-add,icon-flag,icon-twitter,icon-gplus,icon-github,icon-facebook,icon-step-backward,icon-backward,icon-pause,icon-stop,icon-forward,icon-step-forward,icon-play";
        String template = "<li class=\"bt-icon %s\"></li>";
        String[] icons = iconsStr.split(",");

        for (String icon : icons) {
            System.out.println(String.format(template, icon));
        }

    }

}
