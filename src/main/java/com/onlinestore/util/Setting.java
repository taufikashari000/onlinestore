package com.onlinestore.util;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Setting {
    static Locale[] supportedLocales = { Locale.ENGLISH };

    static Locale activeLocale = Locale.ENGLISH;

    static ResourceBundle resourceBundle = null;

    static Boolean isLocaleChanged = true;


    public static void setLocale(Locale newLocale) {
        if (Arrays.asList(supportedLocales).contains(newLocale)) {
            activeLocale = newLocale;
            isLocaleChanged = true;
        }
    }

    public static ResourceBundle getResourceBundle() {
        if ((resourceBundle == null) || (isLocaleChanged)) {
            resourceBundle = ResourceBundle
                    .getBundle("strings/Resource", activeLocale);
        }
        return resourceBundle;
    }

    public static ResourceBundle getErrorBundle() {
        if ((resourceBundle == null) || (isLocaleChanged)) {
            resourceBundle = ResourceBundle.getBundle("strings/Error",
                    activeLocale);
        }
        return resourceBundle;
    }

    public static String getErrorString(String key) {
        try {
            return getErrorBundle().getString(key);
        } catch (MissingResourceException e) {
            return "!" + key + "!";
        } catch (Exception e) {
            return "#!" + key + "!#";
        }
    }

    public static String getResourceString(String key) {
        try {
            return getResourceBundle().getString(key);
        } catch (MissingResourceException e) {
            return "!" + key + "!";
        } catch (Exception e) {
            return "#!" + key + "!#";
        }
    }

    public static String getResourceString(String key, Object... params) {
        try {
            return MessageFormat.format(getResourceBundle().getString(key), params);
        } catch (MissingResourceException e) {
            return "!" + key + "!";
        } catch (Exception e) {
            return "#!" + key + "!#";
        }
    }

}
