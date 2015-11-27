package com.beardedhen.androidbootstrap.font;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/**
 * Maps Typicons Icon Codes to unicode characters, allowing its use in AwesomeTextView.
 * See the <a href='http://typicons.com/'>Cheatsheet</a> for icon
 * code reference. <b>Please note that icon codes have been prefixed with "ty_".</b>
 * For example, "adjust_brightness" would become "ty_adjust_brightness".
 */
public class Typicon implements IconSet {

    public static final String FONT_PATH = "typicons-v207.ttf";

    private static final Map<String, String> ICON_MAP = new HashMap<>();
    private static final Map<Integer, String> ATTR_MAP = new HashMap<>();

    @Override public CharSequence unicodeForKey(@Icon CharSequence key) {
        return ICON_MAP.get(key);
    }

    @Override public CharSequence iconCodeForAttrIndex(int index) {
        return ATTR_MAP.get(index);
    }

    @Override public CharSequence fontPath() {
        return FONT_PATH;
    }

    // Auto-generated Icon Set from 2015-10-05

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            TY_ADJUST_BRIGHTNESS,
            TY_ADJUST_CONTRAST,
            TY_ANCHOR,
            TY_ANCHOR_OUTLINE,
            TY_ARCHIVE,
            TY_ARROW_BACK,
            TY_ARROW_BACK_OUTLINE,
            TY_ARROW_DOWN,
            TY_ARROW_DOWN_OUTLINE,
            TY_ARROW_DOWN_THICK,
            TY_ARROW_FORWARD,
            TY_ARROW_FORWARD_OUTLINE,
            TY_ARROW_LEFT,
            TY_ARROW_LEFT_OUTLINE,
            TY_ARROW_LEFT_THICK,
            TY_ARROW_LOOP,
            TY_ARROW_LOOP_OUTLINE,
            TY_ARROW_MAXIMISE,
            TY_ARROW_MAXIMISE_OUTLINE,
            TY_ARROW_MINIMISE,
            TY_ARROW_MINIMISE_OUTLINE,
            TY_ARROW_MOVE,
            TY_ARROW_MOVE_OUTLINE,
            TY_ARROW_REPEAT,
            TY_ARROW_REPEAT_OUTLINE,
            TY_ARROW_RIGHT,
            TY_ARROW_RIGHT_OUTLINE,
            TY_ARROW_RIGHT_THICK,
            TY_ARROW_SHUFFLE,
            TY_ARROW_SORTED_DOWN,
            TY_ARROW_SORTED_UP,
            TY_ARROW_SYNC,
            TY_ARROW_SYNC_OUTLINE,
            TY_ARROW_UNSORTED,
            TY_ARROW_UP,
            TY_ARROW_UP_OUTLINE,
            TY_ARROW_UP_THICK,
            TY_AT,
            TY_ATTACHMENT,
            TY_ATTACHMENT_OUTLINE,
            TY_BACKSPACE,
            TY_BACKSPACE_OUTLINE,
            TY_BATTERY_CHARGE,
            TY_BATTERY_FULL,
            TY_BATTERY_HIGH,
            TY_BATTERY_LOW,
            TY_BATTERY_MID,
            TY_BEAKER,
            TY_BEER,
            TY_BELL,
            TY_BOOK,
            TY_BOOKMARK,
            TY_BRIEFCASE,
            TY_BRUSH,
            TY_BUSINESS_CARD,
            TY_CALCULATOR,
            TY_CALENDAR,
            TY_CALENDAR_OUTLINE,
            TY_CAMERA,
            TY_CAMERA_OUTLINE,
            TY_CANCEL,
            TY_CANCEL_OUTLINE,
            TY_CHART_AREA,
            TY_CHART_AREA_OUTLINE,
            TY_CHART_BAR,
            TY_CHART_BAR_OUTLINE,
            TY_CHART_LINE,
            TY_CHART_LINE_OUTLINE,
            TY_CHART_PIE,
            TY_CHART_PIE_OUTLINE,
            TY_CHEVRON_LEFT,
            TY_CHEVRON_LEFT_OUTLINE,
            TY_CHEVRON_RIGHT,
            TY_CHEVRON_RIGHT_OUTLINE,
            TY_CLIPBOARD,
            TY_CLOUD_STORAGE,
            TY_CLOUD_STORAGE_OUTLINE,
            TY_CODE,
            TY_CODE_OUTLINE,
            TY_COFFEE,
            TY_COG,
            TY_COG_OUTLINE,
            TY_COMPASS,
            TY_CONTACTS,
            TY_CREDIT_CARD,
            TY_CSS3,
            TY_DATABASE,
            TY_DELETE,
            TY_DELETE_OUTLINE,
            TY_DEVICE_DESKTOP,
            TY_DEVICE_LAPTOP,
            TY_DEVICE_PHONE,
            TY_DEVICE_TABLET,
            TY_DIRECTIONS,
            TY_DIVIDE,
            TY_DIVIDE_OUTLINE,
            TY_DOCUMENT,
            TY_DOCUMENT_ADD,
            TY_DOCUMENT_DELETE,
            TY_DOCUMENT_TEXT,
            TY_DOWNLOAD,
            TY_DOWNLOAD_OUTLINE,
            TY_DROPBOX,
            TY_EDIT,
            TY_EJECT,
            TY_EJECT_OUTLINE,
            TY_EQUALS,
            TY_EQUALS_OUTLINE,
            TY_EXPORT,
            TY_EXPORT_OUTLINE,
            TY_EYE,
            TY_EYE_OUTLINE,
            TY_FEATHER,
            TY_FILM,
            TY_FILTER,
            TY_FLAG,
            TY_FLAG_OUTLINE,
            TY_FLASH,
            TY_FLASH_OUTLINE,
            TY_FLOW_CHILDREN,
            TY_FLOW_MERGE,
            TY_FLOW_PARALLEL,
            TY_FLOW_SWITCH,
            TY_FOLDER,
            TY_FOLDER_ADD,
            TY_FOLDER_DELETE,
            TY_FOLDER_OPEN,
            TY_GIFT,
            TY_GLOBE,
            TY_GLOBE_OUTLINE,
            TY_GROUP,
            TY_GROUP_OUTLINE,
            TY_HEADPHONES,
            TY_HEART,
            TY_HEART_FULL_OUTLINE,
            TY_HEART_HALF_OUTLINE,
            TY_HEART_OUTLINE,
            TY_HOME,
            TY_HOME_OUTLINE,
            TY_HTML5,
            TY_IMAGE,
            TY_IMAGE_OUTLINE,
            TY_INFINITY,
            TY_INFINITY_OUTLINE,
            TY_INFO,
            TY_INFO_LARGE,
            TY_INFO_LARGE_OUTLINE,
            TY_INFO_OUTLINE,
            TY_INPUT_CHECKED,
            TY_INPUT_CHECKED_OUTLINE,
            TY_KEY,
            TY_KEY_OUTLINE,
            TY_KEYBOARD,
            TY_LEAF,
            TY_LIGHTBULB,
            TY_LINK,
            TY_LINK_OUTLINE,
            TY_LOCATION,
            TY_LOCATION_ARROW,
            TY_LOCATION_ARROW_OUTLINE,
            TY_LOCATION_OUTLINE,
            TY_LOCK_CLOSED,
            TY_LOCK_CLOSED_OUTLINE,
            TY_LOCK_OPEN,
            TY_LOCK_OPEN_OUTLINE,
            TY_MAIL,
            TY_MAP,
            TY_MEDIA_EJECT,
            TY_MEDIA_EJECT_OUTLINE,
            TY_MEDIA_FAST_FORWARD,
            TY_MEDIA_FAST_FORWARD_OUTLINE,
            TY_MEDIA_PAUSE,
            TY_MEDIA_PAUSE_OUTLINE,
            TY_MEDIA_PLAY,
            TY_MEDIA_PLAY_OUTLINE,
            TY_MEDIA_PLAY_REVERSE,
            TY_MEDIA_PLAY_REVERSE_OUTLINE,
            TY_MEDIA_RECORD,
            TY_MEDIA_RECORD_OUTLINE,
            TY_MEDIA_REWIND,
            TY_MEDIA_REWIND_OUTLINE,
            TY_MEDIA_STOP,
            TY_MEDIA_STOP_OUTLINE,
            TY_MESSAGE,
            TY_MESSAGE_TYPING,
            TY_MESSAGES,
            TY_MICROPHONE,
            TY_MICROPHONE_OUTLINE,
            TY_MINUS,
            TY_MINUS_OUTLINE,
            TY_MORTAR_BOARD,
            TY_NEWS,
            TY_NOTES,
            TY_NOTES_OUTLINE,
            TY_PEN,
            TY_PENCIL,
            TY_PHONE,
            TY_PHONE_OUTLINE,
            TY_PI,
            TY_PI_OUTLINE,
            TY_PIN,
            TY_PIN_OUTLINE,
            TY_PIPETTE,
            TY_PLANE,
            TY_PLANE_OUTLINE,
            TY_PLUG,
            TY_PLUS,
            TY_PLUS_OUTLINE,
            TY_POINT_OF_INTEREST,
            TY_POINT_OF_INTEREST_OUTLINE,
            TY_POWER,
            TY_POWER_OUTLINE,
            TY_PRINTER,
            TY_PUZZLE,
            TY_PUZZLE_OUTLINE,
            TY_RADAR,
            TY_RADAR_OUTLINE,
            TY_REFRESH,
            TY_REFRESH_OUTLINE,
            TY_RSS,
            TY_RSS_OUTLINE,
            TY_SCISSORS,
            TY_SCISSORS_OUTLINE,
            TY_SHOPPING_BAG,
            TY_SHOPPING_CART,
            TY_SOCIAL_AT_CIRCULAR,
            TY_SOCIAL_DRIBBBLE,
            TY_SOCIAL_DRIBBBLE_CIRCULAR,
            TY_SOCIAL_FACEBOOK,
            TY_SOCIAL_FACEBOOK_CIRCULAR,
            TY_SOCIAL_FLICKR,
            TY_SOCIAL_FLICKR_CIRCULAR,
            TY_SOCIAL_GITHUB,
            TY_SOCIAL_GITHUB_CIRCULAR,
            TY_SOCIAL_GOOGLE_PLUS,
            TY_SOCIAL_GOOGLE_PLUS_CIRCULAR,
            TY_SOCIAL_INSTAGRAM,
            TY_SOCIAL_INSTAGRAM_CIRCULAR,
            TY_SOCIAL_LAST_FM,
            TY_SOCIAL_LAST_FM_CIRCULAR,
            TY_SOCIAL_LINKEDIN,
            TY_SOCIAL_LINKEDIN_CIRCULAR,
            TY_SOCIAL_PINTEREST,
            TY_SOCIAL_PINTEREST_CIRCULAR,
            TY_SOCIAL_SKYPE,
            TY_SOCIAL_SKYPE_OUTLINE,
            TY_SOCIAL_TUMBLER,
            TY_SOCIAL_TUMBLER_CIRCULAR,
            TY_SOCIAL_TWITTER,
            TY_SOCIAL_TWITTER_CIRCULAR,
            TY_SOCIAL_VIMEO,
            TY_SOCIAL_VIMEO_CIRCULAR,
            TY_SOCIAL_YOUTUBE,
            TY_SOCIAL_YOUTUBE_CIRCULAR,
            TY_SORT_ALPHABETICALLY,
            TY_SORT_ALPHABETICALLY_OUTLINE,
            TY_SORT_NUMERICALLY,
            TY_SORT_NUMERICALLY_OUTLINE,
            TY_SPANNER,
            TY_SPANNER_OUTLINE,
            TY_SPIRAL,
            TY_STAR,
            TY_STAR_FULL_OUTLINE,
            TY_STAR_HALF,
            TY_STAR_HALF_OUTLINE,
            TY_STAR_OUTLINE,
            TY_STARBURST,
            TY_STARBURST_OUTLINE,
            TY_STOPWATCH,
            TY_SUPPORT,
            TY_TABS_OUTLINE,
            TY_TAG,
            TY_TAGS,
            TY_TH_LARGE,
            TY_TH_LARGE_OUTLINE,
            TY_TH_LIST,
            TY_TH_LIST_OUTLINE,
            TY_TH_MENU,
            TY_TH_MENU_OUTLINE,
            TY_TH_SMALL,
            TY_TH_SMALL_OUTLINE,
            TY_THERMOMETER,
            TY_THUMBS_DOWN,
            TY_THUMBS_OK,
            TY_THUMBS_UP,
            TY_TICK,
            TY_TICK_OUTLINE,
            TY_TICKET,
            TY_TIME,
            TY_TIMES,
            TY_TIMES_OUTLINE,
            TY_TRASH,
            TY_TREE,
            TY_UPLOAD,
            TY_UPLOAD_OUTLINE,
            TY_USER,
            TY_USER_ADD,
            TY_USER_ADD_OUTLINE,
            TY_USER_DELETE,
            TY_USER_DELETE_OUTLINE,
            TY_USER_OUTLINE,
            TY_VENDOR_ANDROID,
            TY_VENDOR_APPLE,
            TY_VENDOR_MICROSOFT,
            TY_VIDEO,
            TY_VIDEO_OUTLINE,
            TY_VOLUME,
            TY_VOLUME_DOWN,
            TY_VOLUME_MUTE,
            TY_VOLUME_UP,
            TY_WARNING,
            TY_WARNING_OUTLINE,
            TY_WATCH,
            TY_WAVES,
            TY_WAVES_OUTLINE,
            TY_WEATHER_CLOUDY,
            TY_WEATHER_DOWNPOUR,
            TY_WEATHER_NIGHT,
            TY_WEATHER_PARTLY_SUNNY,
            TY_WEATHER_SHOWER,
            TY_WEATHER_SNOW,
            TY_WEATHER_STORMY,
            TY_WEATHER_SUNNY,
            TY_WEATHER_WINDY,
            TY_WEATHER_WINDY_CLOUDY,
            TY_WI_FI,
            TY_WI_FI_OUTLINE,
            TY_WINE,
            TY_WORLD,
            TY_WORLD_OUTLINE,
            TY_ZOOM,
            TY_ZOOM_IN,
            TY_ZOOM_IN_OUTLINE,
            TY_ZOOM_OUT,
            TY_ZOOM_OUT_OUTLINE,
            TY_ZOOM_OUTLINE,
    }) public @interface Icon {
    }

    public static final String TY_ADJUST_BRIGHTNESS = "ty_adjust_brightness";
    public static final String TY_ADJUST_CONTRAST = "ty_adjust_contrast";
    public static final String TY_ANCHOR = "ty_anchor";
    public static final String TY_ANCHOR_OUTLINE = "ty_anchor_outline";
    public static final String TY_ARCHIVE = "ty_archive";
    public static final String TY_ARROW_BACK = "ty_arrow_back";
    public static final String TY_ARROW_BACK_OUTLINE = "ty_arrow_back_outline";
    public static final String TY_ARROW_DOWN = "ty_arrow_down";
    public static final String TY_ARROW_DOWN_OUTLINE = "ty_arrow_down_outline";
    public static final String TY_ARROW_DOWN_THICK = "ty_arrow_down_thick";
    public static final String TY_ARROW_FORWARD = "ty_arrow_forward";
    public static final String TY_ARROW_FORWARD_OUTLINE = "ty_arrow_forward_outline";
    public static final String TY_ARROW_LEFT = "ty_arrow_left";
    public static final String TY_ARROW_LEFT_OUTLINE = "ty_arrow_left_outline";
    public static final String TY_ARROW_LEFT_THICK = "ty_arrow_left_thick";
    public static final String TY_ARROW_LOOP = "ty_arrow_loop";
    public static final String TY_ARROW_LOOP_OUTLINE = "ty_arrow_loop_outline";
    public static final String TY_ARROW_MAXIMISE = "ty_arrow_maximise";
    public static final String TY_ARROW_MAXIMISE_OUTLINE = "ty_arrow_maximise_outline";
    public static final String TY_ARROW_MINIMISE = "ty_arrow_minimise";
    public static final String TY_ARROW_MINIMISE_OUTLINE = "ty_arrow_minimise_outline";
    public static final String TY_ARROW_MOVE = "ty_arrow_move";
    public static final String TY_ARROW_MOVE_OUTLINE = "ty_arrow_move_outline";
    public static final String TY_ARROW_REPEAT = "ty_arrow_repeat";
    public static final String TY_ARROW_REPEAT_OUTLINE = "ty_arrow_repeat_outline";
    public static final String TY_ARROW_RIGHT = "ty_arrow_right";
    public static final String TY_ARROW_RIGHT_OUTLINE = "ty_arrow_right_outline";
    public static final String TY_ARROW_RIGHT_THICK = "ty_arrow_right_thick";
    public static final String TY_ARROW_SHUFFLE = "ty_arrow_shuffle";
    public static final String TY_ARROW_SORTED_DOWN = "ty_arrow_sorted_down";
    public static final String TY_ARROW_SORTED_UP = "ty_arrow_sorted_up";
    public static final String TY_ARROW_SYNC = "ty_arrow_sync";
    public static final String TY_ARROW_SYNC_OUTLINE = "ty_arrow_sync_outline";
    public static final String TY_ARROW_UNSORTED = "ty_arrow_unsorted";
    public static final String TY_ARROW_UP = "ty_arrow_up";
    public static final String TY_ARROW_UP_OUTLINE = "ty_arrow_up_outline";
    public static final String TY_ARROW_UP_THICK = "ty_arrow_up_thick";
    public static final String TY_AT = "ty_at";
    public static final String TY_ATTACHMENT = "ty_attachment";
    public static final String TY_ATTACHMENT_OUTLINE = "ty_attachment_outline";
    public static final String TY_BACKSPACE = "ty_backspace";
    public static final String TY_BACKSPACE_OUTLINE = "ty_backspace_outline";
    public static final String TY_BATTERY_CHARGE = "ty_battery_charge";
    public static final String TY_BATTERY_FULL = "ty_battery_full";
    public static final String TY_BATTERY_HIGH = "ty_battery_high";
    public static final String TY_BATTERY_LOW = "ty_battery_low";
    public static final String TY_BATTERY_MID = "ty_battery_mid";
    public static final String TY_BEAKER = "ty_beaker";
    public static final String TY_BEER = "ty_beer";
    public static final String TY_BELL = "ty_bell";
    public static final String TY_BOOK = "ty_book";
    public static final String TY_BOOKMARK = "ty_bookmark";
    public static final String TY_BRIEFCASE = "ty_briefcase";
    public static final String TY_BRUSH = "ty_brush";
    public static final String TY_BUSINESS_CARD = "ty_business_card";
    public static final String TY_CALCULATOR = "ty_calculator";
    public static final String TY_CALENDAR = "ty_calendar";
    public static final String TY_CALENDAR_OUTLINE = "ty_calendar_outline";
    public static final String TY_CAMERA = "ty_camera";
    public static final String TY_CAMERA_OUTLINE = "ty_camera_outline";
    public static final String TY_CANCEL = "ty_cancel";
    public static final String TY_CANCEL_OUTLINE = "ty_cancel_outline";
    public static final String TY_CHART_AREA = "ty_chart_area";
    public static final String TY_CHART_AREA_OUTLINE = "ty_chart_area_outline";
    public static final String TY_CHART_BAR = "ty_chart_bar";
    public static final String TY_CHART_BAR_OUTLINE = "ty_chart_bar_outline";
    public static final String TY_CHART_LINE = "ty_chart_line";
    public static final String TY_CHART_LINE_OUTLINE = "ty_chart_line_outline";
    public static final String TY_CHART_PIE = "ty_chart_pie";
    public static final String TY_CHART_PIE_OUTLINE = "ty_chart_pie_outline";
    public static final String TY_CHEVRON_LEFT = "ty_chevron_left";
    public static final String TY_CHEVRON_LEFT_OUTLINE = "ty_chevron_left_outline";
    public static final String TY_CHEVRON_RIGHT = "ty_chevron_right";
    public static final String TY_CHEVRON_RIGHT_OUTLINE = "ty_chevron_right_outline";
    public static final String TY_CLIPBOARD = "ty_clipboard";
    public static final String TY_CLOUD_STORAGE = "ty_cloud_storage";
    public static final String TY_CLOUD_STORAGE_OUTLINE = "ty_cloud_storage_outline";
    public static final String TY_CODE = "ty_code";
    public static final String TY_CODE_OUTLINE = "ty_code_outline";
    public static final String TY_COFFEE = "ty_coffee";
    public static final String TY_COG = "ty_cog";
    public static final String TY_COG_OUTLINE = "ty_cog_outline";
    public static final String TY_COMPASS = "ty_compass";
    public static final String TY_CONTACTS = "ty_contacts";
    public static final String TY_CREDIT_CARD = "ty_credit_card";
    public static final String TY_CSS3 = "ty_css3";
    public static final String TY_DATABASE = "ty_database";
    public static final String TY_DELETE = "ty_delete";
    public static final String TY_DELETE_OUTLINE = "ty_delete_outline";
    public static final String TY_DEVICE_DESKTOP = "ty_device_desktop";
    public static final String TY_DEVICE_LAPTOP = "ty_device_laptop";
    public static final String TY_DEVICE_PHONE = "ty_device_phone";
    public static final String TY_DEVICE_TABLET = "ty_device_tablet";
    public static final String TY_DIRECTIONS = "ty_directions";
    public static final String TY_DIVIDE = "ty_divide";
    public static final String TY_DIVIDE_OUTLINE = "ty_divide_outline";
    public static final String TY_DOCUMENT = "ty_document";
    public static final String TY_DOCUMENT_ADD = "ty_document_add";
    public static final String TY_DOCUMENT_DELETE = "ty_document_delete";
    public static final String TY_DOCUMENT_TEXT = "ty_document_text";
    public static final String TY_DOWNLOAD = "ty_download";
    public static final String TY_DOWNLOAD_OUTLINE = "ty_download_outline";
    public static final String TY_DROPBOX = "ty_dropbox";
    public static final String TY_EDIT = "ty_edit";
    public static final String TY_EJECT = "ty_eject";
    public static final String TY_EJECT_OUTLINE = "ty_eject_outline";
    public static final String TY_EQUALS = "ty_equals";
    public static final String TY_EQUALS_OUTLINE = "ty_equals_outline";
    public static final String TY_EXPORT = "ty_export";
    public static final String TY_EXPORT_OUTLINE = "ty_export_outline";
    public static final String TY_EYE = "ty_eye";
    public static final String TY_EYE_OUTLINE = "ty_eye_outline";
    public static final String TY_FEATHER = "ty_feather";
    public static final String TY_FILM = "ty_film";
    public static final String TY_FILTER = "ty_filter";
    public static final String TY_FLAG = "ty_flag";
    public static final String TY_FLAG_OUTLINE = "ty_flag_outline";
    public static final String TY_FLASH = "ty_flash";
    public static final String TY_FLASH_OUTLINE = "ty_flash_outline";
    public static final String TY_FLOW_CHILDREN = "ty_flow_children";
    public static final String TY_FLOW_MERGE = "ty_flow_merge";
    public static final String TY_FLOW_PARALLEL = "ty_flow_parallel";
    public static final String TY_FLOW_SWITCH = "ty_flow_switch";
    public static final String TY_FOLDER = "ty_folder";
    public static final String TY_FOLDER_ADD = "ty_folder_add";
    public static final String TY_FOLDER_DELETE = "ty_folder_delete";
    public static final String TY_FOLDER_OPEN = "ty_folder_open";
    public static final String TY_GIFT = "ty_gift";
    public static final String TY_GLOBE = "ty_globe";
    public static final String TY_GLOBE_OUTLINE = "ty_globe_outline";
    public static final String TY_GROUP = "ty_group";
    public static final String TY_GROUP_OUTLINE = "ty_group_outline";
    public static final String TY_HEADPHONES = "ty_headphones";
    public static final String TY_HEART = "ty_heart";
    public static final String TY_HEART_FULL_OUTLINE = "ty_heart_full_outline";
    public static final String TY_HEART_HALF_OUTLINE = "ty_heart_half_outline";
    public static final String TY_HEART_OUTLINE = "ty_heart_outline";
    public static final String TY_HOME = "ty_home";
    public static final String TY_HOME_OUTLINE = "ty_home_outline";
    public static final String TY_HTML5 = "ty_html5";
    public static final String TY_IMAGE = "ty_image";
    public static final String TY_IMAGE_OUTLINE = "ty_image_outline";
    public static final String TY_INFINITY = "ty_infinity";
    public static final String TY_INFINITY_OUTLINE = "ty_infinity_outline";
    public static final String TY_INFO = "ty_info";
    public static final String TY_INFO_LARGE = "ty_info_large";
    public static final String TY_INFO_LARGE_OUTLINE = "ty_info_large_outline";
    public static final String TY_INFO_OUTLINE = "ty_info_outline";
    public static final String TY_INPUT_CHECKED = "ty_input_checked";
    public static final String TY_INPUT_CHECKED_OUTLINE = "ty_input_checked_outline";
    public static final String TY_KEY = "ty_key";
    public static final String TY_KEY_OUTLINE = "ty_key_outline";
    public static final String TY_KEYBOARD = "ty_keyboard";
    public static final String TY_LEAF = "ty_leaf";
    public static final String TY_LIGHTBULB = "ty_lightbulb";
    public static final String TY_LINK = "ty_link";
    public static final String TY_LINK_OUTLINE = "ty_link_outline";
    public static final String TY_LOCATION = "ty_location";
    public static final String TY_LOCATION_ARROW = "ty_location_arrow";
    public static final String TY_LOCATION_ARROW_OUTLINE = "ty_location_arrow_outline";
    public static final String TY_LOCATION_OUTLINE = "ty_location_outline";
    public static final String TY_LOCK_CLOSED = "ty_lock_closed";
    public static final String TY_LOCK_CLOSED_OUTLINE = "ty_lock_closed_outline";
    public static final String TY_LOCK_OPEN = "ty_lock_open";
    public static final String TY_LOCK_OPEN_OUTLINE = "ty_lock_open_outline";
    public static final String TY_MAIL = "ty_mail";
    public static final String TY_MAP = "ty_map";
    public static final String TY_MEDIA_EJECT = "ty_media_eject";
    public static final String TY_MEDIA_EJECT_OUTLINE = "ty_media_eject_outline";
    public static final String TY_MEDIA_FAST_FORWARD = "ty_media_fast_forward";
    public static final String TY_MEDIA_FAST_FORWARD_OUTLINE = "ty_media_fast_forward_outline";
    public static final String TY_MEDIA_PAUSE = "ty_media_pause";
    public static final String TY_MEDIA_PAUSE_OUTLINE = "ty_media_pause_outline";
    public static final String TY_MEDIA_PLAY = "ty_media_play";
    public static final String TY_MEDIA_PLAY_OUTLINE = "ty_media_play_outline";
    public static final String TY_MEDIA_PLAY_REVERSE = "ty_media_play_reverse";
    public static final String TY_MEDIA_PLAY_REVERSE_OUTLINE = "ty_media_play_reverse_outline";
    public static final String TY_MEDIA_RECORD = "ty_media_record";
    public static final String TY_MEDIA_RECORD_OUTLINE = "ty_media_record_outline";
    public static final String TY_MEDIA_REWIND = "ty_media_rewind";
    public static final String TY_MEDIA_REWIND_OUTLINE = "ty_media_rewind_outline";
    public static final String TY_MEDIA_STOP = "ty_media_stop";
    public static final String TY_MEDIA_STOP_OUTLINE = "ty_media_stop_outline";
    public static final String TY_MESSAGE = "ty_message";
    public static final String TY_MESSAGE_TYPING = "ty_message_typing";
    public static final String TY_MESSAGES = "ty_messages";
    public static final String TY_MICROPHONE = "ty_microphone";
    public static final String TY_MICROPHONE_OUTLINE = "ty_microphone_outline";
    public static final String TY_MINUS = "ty_minus";
    public static final String TY_MINUS_OUTLINE = "ty_minus_outline";
    public static final String TY_MORTAR_BOARD = "ty_mortar_board";
    public static final String TY_NEWS = "ty_news";
    public static final String TY_NOTES = "ty_notes";
    public static final String TY_NOTES_OUTLINE = "ty_notes_outline";
    public static final String TY_PEN = "ty_pen";
    public static final String TY_PENCIL = "ty_pencil";
    public static final String TY_PHONE = "ty_phone";
    public static final String TY_PHONE_OUTLINE = "ty_phone_outline";
    public static final String TY_PI = "ty_pi";
    public static final String TY_PI_OUTLINE = "ty_pi_outline";
    public static final String TY_PIN = "ty_pin";
    public static final String TY_PIN_OUTLINE = "ty_pin_outline";
    public static final String TY_PIPETTE = "ty_pipette";
    public static final String TY_PLANE = "ty_plane";
    public static final String TY_PLANE_OUTLINE = "ty_plane_outline";
    public static final String TY_PLUG = "ty_plug";
    public static final String TY_PLUS = "ty_plus";
    public static final String TY_PLUS_OUTLINE = "ty_plus_outline";
    public static final String TY_POINT_OF_INTEREST = "ty_point_of_interest";
    public static final String TY_POINT_OF_INTEREST_OUTLINE = "ty_point_of_interest_outline";
    public static final String TY_POWER = "ty_power";
    public static final String TY_POWER_OUTLINE = "ty_power_outline";
    public static final String TY_PRINTER = "ty_printer";
    public static final String TY_PUZZLE = "ty_puzzle";
    public static final String TY_PUZZLE_OUTLINE = "ty_puzzle_outline";
    public static final String TY_RADAR = "ty_radar";
    public static final String TY_RADAR_OUTLINE = "ty_radar_outline";
    public static final String TY_REFRESH = "ty_refresh";
    public static final String TY_REFRESH_OUTLINE = "ty_refresh_outline";
    public static final String TY_RSS = "ty_rss";
    public static final String TY_RSS_OUTLINE = "ty_rss_outline";
    public static final String TY_SCISSORS = "ty_scissors";
    public static final String TY_SCISSORS_OUTLINE = "ty_scissors_outline";
    public static final String TY_SHOPPING_BAG = "ty_shopping_bag";
    public static final String TY_SHOPPING_CART = "ty_shopping_cart";
    public static final String TY_SOCIAL_AT_CIRCULAR = "ty_social_at_circular";
    public static final String TY_SOCIAL_DRIBBBLE = "ty_social_dribbble";
    public static final String TY_SOCIAL_DRIBBBLE_CIRCULAR = "ty_social_dribbble_circular";
    public static final String TY_SOCIAL_FACEBOOK = "ty_social_facebook";
    public static final String TY_SOCIAL_FACEBOOK_CIRCULAR = "ty_social_facebook_circular";
    public static final String TY_SOCIAL_FLICKR = "ty_social_flickr";
    public static final String TY_SOCIAL_FLICKR_CIRCULAR = "ty_social_flickr_circular";
    public static final String TY_SOCIAL_GITHUB = "ty_social_github";
    public static final String TY_SOCIAL_GITHUB_CIRCULAR = "ty_social_github_circular";
    public static final String TY_SOCIAL_GOOGLE_PLUS = "ty_social_google_plus";
    public static final String TY_SOCIAL_GOOGLE_PLUS_CIRCULAR = "ty_social_google_plus_circular";
    public static final String TY_SOCIAL_INSTAGRAM = "ty_social_instagram";
    public static final String TY_SOCIAL_INSTAGRAM_CIRCULAR = "ty_social_instagram_circular";
    public static final String TY_SOCIAL_LAST_FM = "ty_social_last_fm";
    public static final String TY_SOCIAL_LAST_FM_CIRCULAR = "ty_social_last_fm_circular";
    public static final String TY_SOCIAL_LINKEDIN = "ty_social_linkedin";
    public static final String TY_SOCIAL_LINKEDIN_CIRCULAR = "ty_social_linkedin_circular";
    public static final String TY_SOCIAL_PINTEREST = "ty_social_pinterest";
    public static final String TY_SOCIAL_PINTEREST_CIRCULAR = "ty_social_pinterest_circular";
    public static final String TY_SOCIAL_SKYPE = "ty_social_skype";
    public static final String TY_SOCIAL_SKYPE_OUTLINE = "ty_social_skype_outline";
    public static final String TY_SOCIAL_TUMBLER = "ty_social_tumbler";
    public static final String TY_SOCIAL_TUMBLER_CIRCULAR = "ty_social_tumbler_circular";
    public static final String TY_SOCIAL_TWITTER = "ty_social_twitter";
    public static final String TY_SOCIAL_TWITTER_CIRCULAR = "ty_social_twitter_circular";
    public static final String TY_SOCIAL_VIMEO = "ty_social_vimeo";
    public static final String TY_SOCIAL_VIMEO_CIRCULAR = "ty_social_vimeo_circular";
    public static final String TY_SOCIAL_YOUTUBE = "ty_social_youtube";
    public static final String TY_SOCIAL_YOUTUBE_CIRCULAR = "ty_social_youtube_circular";
    public static final String TY_SORT_ALPHABETICALLY = "ty_sort_alphabetically";
    public static final String TY_SORT_ALPHABETICALLY_OUTLINE = "ty_sort_alphabetically_outline";
    public static final String TY_SORT_NUMERICALLY = "ty_sort_numerically";
    public static final String TY_SORT_NUMERICALLY_OUTLINE = "ty_sort_numerically_outline";
    public static final String TY_SPANNER = "ty_spanner";
    public static final String TY_SPANNER_OUTLINE = "ty_spanner_outline";
    public static final String TY_SPIRAL = "ty_spiral";
    public static final String TY_STAR = "ty_star";
    public static final String TY_STAR_FULL_OUTLINE = "ty_star_full_outline";
    public static final String TY_STAR_HALF = "ty_star_half";
    public static final String TY_STAR_HALF_OUTLINE = "ty_star_half_outline";
    public static final String TY_STAR_OUTLINE = "ty_star_outline";
    public static final String TY_STARBURST = "ty_starburst";
    public static final String TY_STARBURST_OUTLINE = "ty_starburst_outline";
    public static final String TY_STOPWATCH = "ty_stopwatch";
    public static final String TY_SUPPORT = "ty_support";
    public static final String TY_TABS_OUTLINE = "ty_tabs_outline";
    public static final String TY_TAG = "ty_tag";
    public static final String TY_TAGS = "ty_tags";
    public static final String TY_TH_LARGE = "ty_th_large";
    public static final String TY_TH_LARGE_OUTLINE = "ty_th_large_outline";
    public static final String TY_TH_LIST = "ty_th_list";
    public static final String TY_TH_LIST_OUTLINE = "ty_th_list_outline";
    public static final String TY_TH_MENU = "ty_th_menu";
    public static final String TY_TH_MENU_OUTLINE = "ty_th_menu_outline";
    public static final String TY_TH_SMALL = "ty_th_small";
    public static final String TY_TH_SMALL_OUTLINE = "ty_th_small_outline";
    public static final String TY_THERMOMETER = "ty_thermometer";
    public static final String TY_THUMBS_DOWN = "ty_thumbs_down";
    public static final String TY_THUMBS_OK = "ty_thumbs_ok";
    public static final String TY_THUMBS_UP = "ty_thumbs_up";
    public static final String TY_TICK = "ty_tick";
    public static final String TY_TICK_OUTLINE = "ty_tick_outline";
    public static final String TY_TICKET = "ty_ticket";
    public static final String TY_TIME = "ty_time";
    public static final String TY_TIMES = "ty_times";
    public static final String TY_TIMES_OUTLINE = "ty_times_outline";
    public static final String TY_TRASH = "ty_trash";
    public static final String TY_TREE = "ty_tree";
    public static final String TY_UPLOAD = "ty_upload";
    public static final String TY_UPLOAD_OUTLINE = "ty_upload_outline";
    public static final String TY_USER = "ty_user";
    public static final String TY_USER_ADD = "ty_user_add";
    public static final String TY_USER_ADD_OUTLINE = "ty_user_add_outline";
    public static final String TY_USER_DELETE = "ty_user_delete";
    public static final String TY_USER_DELETE_OUTLINE = "ty_user_delete_outline";
    public static final String TY_USER_OUTLINE = "ty_user_outline";
    public static final String TY_VENDOR_ANDROID = "ty_vendor_android";
    public static final String TY_VENDOR_APPLE = "ty_vendor_apple";
    public static final String TY_VENDOR_MICROSOFT = "ty_vendor_microsoft";
    public static final String TY_VIDEO = "ty_video";
    public static final String TY_VIDEO_OUTLINE = "ty_video_outline";
    public static final String TY_VOLUME = "ty_volume";
    public static final String TY_VOLUME_DOWN = "ty_volume_down";
    public static final String TY_VOLUME_MUTE = "ty_volume_mute";
    public static final String TY_VOLUME_UP = "ty_volume_up";
    public static final String TY_WARNING = "ty_warning";
    public static final String TY_WARNING_OUTLINE = "ty_warning_outline";
    public static final String TY_WATCH = "ty_watch";
    public static final String TY_WAVES = "ty_waves";
    public static final String TY_WAVES_OUTLINE = "ty_waves_outline";
    public static final String TY_WEATHER_CLOUDY = "ty_weather_cloudy";
    public static final String TY_WEATHER_DOWNPOUR = "ty_weather_downpour";
    public static final String TY_WEATHER_NIGHT = "ty_weather_night";
    public static final String TY_WEATHER_PARTLY_SUNNY = "ty_weather_partly_sunny";
    public static final String TY_WEATHER_SHOWER = "ty_weather_shower";
    public static final String TY_WEATHER_SNOW = "ty_weather_snow";
    public static final String TY_WEATHER_STORMY = "ty_weather_stormy";
    public static final String TY_WEATHER_SUNNY = "ty_weather_sunny";
    public static final String TY_WEATHER_WINDY = "ty_weather_windy";
    public static final String TY_WEATHER_WINDY_CLOUDY = "ty_weather_windy_cloudy";
    public static final String TY_WI_FI = "ty_wi_fi";
    public static final String TY_WI_FI_OUTLINE = "ty_wi_fi_outline";
    public static final String TY_WINE = "ty_wine";
    public static final String TY_WORLD = "ty_world";
    public static final String TY_WORLD_OUTLINE = "ty_world_outline";
    public static final String TY_ZOOM = "ty_zoom";
    public static final String TY_ZOOM_IN = "ty_zoom_in";
    public static final String TY_ZOOM_IN_OUTLINE = "ty_zoom_in_outline";
    public static final String TY_ZOOM_OUT = "ty_zoom_out";
    public static final String TY_ZOOM_OUT_OUTLINE = "ty_zoom_out_outline";
    public static final String TY_ZOOM_OUTLINE = "ty_zoom_outline";

    static {
        ICON_MAP.put(TY_ADJUST_BRIGHTNESS, "\ue000");
        ICON_MAP.put(TY_ADJUST_CONTRAST, "\ue001");
        ICON_MAP.put(TY_ANCHOR, "\ue003");
        ICON_MAP.put(TY_ANCHOR_OUTLINE, "\ue002");
        ICON_MAP.put(TY_ARCHIVE, "\ue004");
        ICON_MAP.put(TY_ARROW_BACK, "\ue006");
        ICON_MAP.put(TY_ARROW_BACK_OUTLINE, "\ue005");
        ICON_MAP.put(TY_ARROW_DOWN, "\ue009");
        ICON_MAP.put(TY_ARROW_DOWN_OUTLINE, "\ue007");
        ICON_MAP.put(TY_ARROW_DOWN_THICK, "\ue008");
        ICON_MAP.put(TY_ARROW_FORWARD, "\ue00b");
        ICON_MAP.put(TY_ARROW_FORWARD_OUTLINE, "\ue00a");
        ICON_MAP.put(TY_ARROW_LEFT, "\ue00e");
        ICON_MAP.put(TY_ARROW_LEFT_OUTLINE, "\ue00c");
        ICON_MAP.put(TY_ARROW_LEFT_THICK, "\ue00d");
        ICON_MAP.put(TY_ARROW_LOOP, "\ue010");
        ICON_MAP.put(TY_ARROW_LOOP_OUTLINE, "\ue00f");
        ICON_MAP.put(TY_ARROW_MAXIMISE, "\ue012");
        ICON_MAP.put(TY_ARROW_MAXIMISE_OUTLINE, "\ue011");
        ICON_MAP.put(TY_ARROW_MINIMISE, "\ue014");
        ICON_MAP.put(TY_ARROW_MINIMISE_OUTLINE, "\ue013");
        ICON_MAP.put(TY_ARROW_MOVE, "\ue016");
        ICON_MAP.put(TY_ARROW_MOVE_OUTLINE, "\ue015");
        ICON_MAP.put(TY_ARROW_REPEAT, "\ue018");
        ICON_MAP.put(TY_ARROW_REPEAT_OUTLINE, "\ue017");
        ICON_MAP.put(TY_ARROW_RIGHT, "\ue01b");
        ICON_MAP.put(TY_ARROW_RIGHT_OUTLINE, "\ue019");
        ICON_MAP.put(TY_ARROW_RIGHT_THICK, "\ue01a");
        ICON_MAP.put(TY_ARROW_SHUFFLE, "\ue01c");
        ICON_MAP.put(TY_ARROW_SORTED_DOWN, "\ue01d");
        ICON_MAP.put(TY_ARROW_SORTED_UP, "\ue01e");
        ICON_MAP.put(TY_ARROW_SYNC, "\ue020");
        ICON_MAP.put(TY_ARROW_SYNC_OUTLINE, "\ue01f");
        ICON_MAP.put(TY_ARROW_UNSORTED, "\ue021");
        ICON_MAP.put(TY_ARROW_UP, "\ue024");
        ICON_MAP.put(TY_ARROW_UP_OUTLINE, "\ue022");
        ICON_MAP.put(TY_ARROW_UP_THICK, "\ue023");
        ICON_MAP.put(TY_AT, "\ue025");
        ICON_MAP.put(TY_ATTACHMENT, "\ue027");
        ICON_MAP.put(TY_ATTACHMENT_OUTLINE, "\ue026");
        ICON_MAP.put(TY_BACKSPACE, "\ue029");
        ICON_MAP.put(TY_BACKSPACE_OUTLINE, "\ue028");
        ICON_MAP.put(TY_BATTERY_CHARGE, "\ue02a");
        ICON_MAP.put(TY_BATTERY_FULL, "\ue02b");
        ICON_MAP.put(TY_BATTERY_HIGH, "\ue02c");
        ICON_MAP.put(TY_BATTERY_LOW, "\ue02d");
        ICON_MAP.put(TY_BATTERY_MID, "\ue02e");
        ICON_MAP.put(TY_BEAKER, "\ue02f");
        ICON_MAP.put(TY_BEER, "\ue030");
        ICON_MAP.put(TY_BELL, "\ue031");
        ICON_MAP.put(TY_BOOK, "\ue032");
        ICON_MAP.put(TY_BOOKMARK, "\ue033");
        ICON_MAP.put(TY_BRIEFCASE, "\ue034");
        ICON_MAP.put(TY_BRUSH, "\ue035");
        ICON_MAP.put(TY_BUSINESS_CARD, "\ue036");
        ICON_MAP.put(TY_CALCULATOR, "\ue037");
        ICON_MAP.put(TY_CALENDAR, "\ue039");
        ICON_MAP.put(TY_CALENDAR_OUTLINE, "\ue038");
        ICON_MAP.put(TY_CAMERA, "\ue03b");
        ICON_MAP.put(TY_CAMERA_OUTLINE, "\ue03a");
        ICON_MAP.put(TY_CANCEL, "\ue03d");
        ICON_MAP.put(TY_CANCEL_OUTLINE, "\ue03c");
        ICON_MAP.put(TY_CHART_AREA, "\ue03f");
        ICON_MAP.put(TY_CHART_AREA_OUTLINE, "\ue03e");
        ICON_MAP.put(TY_CHART_BAR, "\ue041");
        ICON_MAP.put(TY_CHART_BAR_OUTLINE, "\ue040");
        ICON_MAP.put(TY_CHART_LINE, "\ue043");
        ICON_MAP.put(TY_CHART_LINE_OUTLINE, "\ue042");
        ICON_MAP.put(TY_CHART_PIE, "\ue045");
        ICON_MAP.put(TY_CHART_PIE_OUTLINE, "\ue044");
        ICON_MAP.put(TY_CHEVRON_LEFT, "\ue047");
        ICON_MAP.put(TY_CHEVRON_LEFT_OUTLINE, "\ue046");
        ICON_MAP.put(TY_CHEVRON_RIGHT, "\ue049");
        ICON_MAP.put(TY_CHEVRON_RIGHT_OUTLINE, "\ue048");
        ICON_MAP.put(TY_CLIPBOARD, "\ue04a");
        ICON_MAP.put(TY_CLOUD_STORAGE, "\ue04b");
        ICON_MAP.put(TY_CLOUD_STORAGE_OUTLINE, "\ue054");
        ICON_MAP.put(TY_CODE, "\ue04d");
        ICON_MAP.put(TY_CODE_OUTLINE, "\ue04c");
        ICON_MAP.put(TY_COFFEE, "\ue04e");
        ICON_MAP.put(TY_COG, "\ue050");
        ICON_MAP.put(TY_COG_OUTLINE, "\ue04f");
        ICON_MAP.put(TY_COMPASS, "\ue051");
        ICON_MAP.put(TY_CONTACTS, "\ue052");
        ICON_MAP.put(TY_CREDIT_CARD, "\ue053");
        ICON_MAP.put(TY_CSS3, "\ue055");
        ICON_MAP.put(TY_DATABASE, "\ue056");
        ICON_MAP.put(TY_DELETE, "\ue058");
        ICON_MAP.put(TY_DELETE_OUTLINE, "\ue057");
        ICON_MAP.put(TY_DEVICE_DESKTOP, "\ue059");
        ICON_MAP.put(TY_DEVICE_LAPTOP, "\ue05a");
        ICON_MAP.put(TY_DEVICE_PHONE, "\ue05b");
        ICON_MAP.put(TY_DEVICE_TABLET, "\ue05c");
        ICON_MAP.put(TY_DIRECTIONS, "\ue05d");
        ICON_MAP.put(TY_DIVIDE, "\ue05f");
        ICON_MAP.put(TY_DIVIDE_OUTLINE, "\ue05e");
        ICON_MAP.put(TY_DOCUMENT, "\ue063");
        ICON_MAP.put(TY_DOCUMENT_ADD, "\ue060");
        ICON_MAP.put(TY_DOCUMENT_DELETE, "\ue061");
        ICON_MAP.put(TY_DOCUMENT_TEXT, "\ue062");
        ICON_MAP.put(TY_DOWNLOAD, "\ue065");
        ICON_MAP.put(TY_DOWNLOAD_OUTLINE, "\ue064");
        ICON_MAP.put(TY_DROPBOX, "\ue066");
        ICON_MAP.put(TY_EDIT, "\ue067");
        ICON_MAP.put(TY_EJECT, "\ue069");
        ICON_MAP.put(TY_EJECT_OUTLINE, "\ue068");
        ICON_MAP.put(TY_EQUALS, "\ue06b");
        ICON_MAP.put(TY_EQUALS_OUTLINE, "\ue06a");
        ICON_MAP.put(TY_EXPORT, "\ue06d");
        ICON_MAP.put(TY_EXPORT_OUTLINE, "\ue06c");
        ICON_MAP.put(TY_EYE, "\ue06f");
        ICON_MAP.put(TY_EYE_OUTLINE, "\ue06e");
        ICON_MAP.put(TY_FEATHER, "\ue070");
        ICON_MAP.put(TY_FILM, "\ue071");
        ICON_MAP.put(TY_FILTER, "\ue072");
        ICON_MAP.put(TY_FLAG, "\ue074");
        ICON_MAP.put(TY_FLAG_OUTLINE, "\ue073");
        ICON_MAP.put(TY_FLASH, "\ue076");
        ICON_MAP.put(TY_FLASH_OUTLINE, "\ue075");
        ICON_MAP.put(TY_FLOW_CHILDREN, "\ue077");
        ICON_MAP.put(TY_FLOW_MERGE, "\ue078");
        ICON_MAP.put(TY_FLOW_PARALLEL, "\ue079");
        ICON_MAP.put(TY_FLOW_SWITCH, "\ue07a");
        ICON_MAP.put(TY_FOLDER, "\ue07e");
        ICON_MAP.put(TY_FOLDER_ADD, "\ue07b");
        ICON_MAP.put(TY_FOLDER_DELETE, "\ue07c");
        ICON_MAP.put(TY_FOLDER_OPEN, "\ue07d");
        ICON_MAP.put(TY_GIFT, "\ue07f");
        ICON_MAP.put(TY_GLOBE, "\ue081");
        ICON_MAP.put(TY_GLOBE_OUTLINE, "\ue080");
        ICON_MAP.put(TY_GROUP, "\ue083");
        ICON_MAP.put(TY_GROUP_OUTLINE, "\ue082");
        ICON_MAP.put(TY_HEADPHONES, "\ue084");
        ICON_MAP.put(TY_HEART, "\ue088");
        ICON_MAP.put(TY_HEART_FULL_OUTLINE, "\ue085");
        ICON_MAP.put(TY_HEART_HALF_OUTLINE, "\ue086");
        ICON_MAP.put(TY_HEART_OUTLINE, "\ue087");
        ICON_MAP.put(TY_HOME, "\ue08a");
        ICON_MAP.put(TY_HOME_OUTLINE, "\ue089");
        ICON_MAP.put(TY_HTML5, "\ue08b");
        ICON_MAP.put(TY_IMAGE, "\ue08d");
        ICON_MAP.put(TY_IMAGE_OUTLINE, "\ue08c");
        ICON_MAP.put(TY_INFINITY, "\ue08f");
        ICON_MAP.put(TY_INFINITY_OUTLINE, "\ue08e");
        ICON_MAP.put(TY_INFO, "\ue093");
        ICON_MAP.put(TY_INFO_LARGE, "\ue091");
        ICON_MAP.put(TY_INFO_LARGE_OUTLINE, "\ue090");
        ICON_MAP.put(TY_INFO_OUTLINE, "\ue092");
        ICON_MAP.put(TY_INPUT_CHECKED, "\ue095");
        ICON_MAP.put(TY_INPUT_CHECKED_OUTLINE, "\ue094");
        ICON_MAP.put(TY_KEY, "\ue097");
        ICON_MAP.put(TY_KEY_OUTLINE, "\ue096");
        ICON_MAP.put(TY_KEYBOARD, "\ue098");
        ICON_MAP.put(TY_LEAF, "\ue099");
        ICON_MAP.put(TY_LIGHTBULB, "\ue09a");
        ICON_MAP.put(TY_LINK, "\ue09c");
        ICON_MAP.put(TY_LINK_OUTLINE, "\ue09b");
        ICON_MAP.put(TY_LOCATION, "\ue0a0");
        ICON_MAP.put(TY_LOCATION_ARROW, "\ue09e");
        ICON_MAP.put(TY_LOCATION_ARROW_OUTLINE, "\ue09d");
        ICON_MAP.put(TY_LOCATION_OUTLINE, "\ue09f");
        ICON_MAP.put(TY_LOCK_CLOSED, "\ue0a2");
        ICON_MAP.put(TY_LOCK_CLOSED_OUTLINE, "\ue0a1");
        ICON_MAP.put(TY_LOCK_OPEN, "\ue0a4");
        ICON_MAP.put(TY_LOCK_OPEN_OUTLINE, "\ue0a3");
        ICON_MAP.put(TY_MAIL, "\ue0a5");
        ICON_MAP.put(TY_MAP, "\ue0a6");
        ICON_MAP.put(TY_MEDIA_EJECT, "\ue0a8");
        ICON_MAP.put(TY_MEDIA_EJECT_OUTLINE, "\ue0a7");
        ICON_MAP.put(TY_MEDIA_FAST_FORWARD, "\ue0aa");
        ICON_MAP.put(TY_MEDIA_FAST_FORWARD_OUTLINE, "\ue0a9");
        ICON_MAP.put(TY_MEDIA_PAUSE, "\ue0ac");
        ICON_MAP.put(TY_MEDIA_PAUSE_OUTLINE, "\ue0ab");
        ICON_MAP.put(TY_MEDIA_PLAY, "\ue0b0");
        ICON_MAP.put(TY_MEDIA_PLAY_OUTLINE, "\ue0ad");
        ICON_MAP.put(TY_MEDIA_PLAY_REVERSE, "\ue0af");
        ICON_MAP.put(TY_MEDIA_PLAY_REVERSE_OUTLINE, "\ue0ae");
        ICON_MAP.put(TY_MEDIA_RECORD, "\ue0b2");
        ICON_MAP.put(TY_MEDIA_RECORD_OUTLINE, "\ue0b1");
        ICON_MAP.put(TY_MEDIA_REWIND, "\ue0b4");
        ICON_MAP.put(TY_MEDIA_REWIND_OUTLINE, "\ue0b3");
        ICON_MAP.put(TY_MEDIA_STOP, "\ue0b6");
        ICON_MAP.put(TY_MEDIA_STOP_OUTLINE, "\ue0b5");
        ICON_MAP.put(TY_MESSAGE, "\ue0b8");
        ICON_MAP.put(TY_MESSAGE_TYPING, "\ue0b7");
        ICON_MAP.put(TY_MESSAGES, "\ue0b9");
        ICON_MAP.put(TY_MICROPHONE, "\ue0bb");
        ICON_MAP.put(TY_MICROPHONE_OUTLINE, "\ue0ba");
        ICON_MAP.put(TY_MINUS, "\ue0bd");
        ICON_MAP.put(TY_MINUS_OUTLINE, "\ue0bc");
        ICON_MAP.put(TY_MORTAR_BOARD, "\ue0be");
        ICON_MAP.put(TY_NEWS, "\ue0bf");
        ICON_MAP.put(TY_NOTES, "\ue0c1");
        ICON_MAP.put(TY_NOTES_OUTLINE, "\ue0c0");
        ICON_MAP.put(TY_PEN, "\ue0c2");
        ICON_MAP.put(TY_PENCIL, "\ue0c3");
        ICON_MAP.put(TY_PHONE, "\ue0c5");
        ICON_MAP.put(TY_PHONE_OUTLINE, "\ue0c4");
        ICON_MAP.put(TY_PI, "\ue0c7");
        ICON_MAP.put(TY_PI_OUTLINE, "\ue0c6");
        ICON_MAP.put(TY_PIN, "\ue0c9");
        ICON_MAP.put(TY_PIN_OUTLINE, "\ue0c8");
        ICON_MAP.put(TY_PIPETTE, "\ue0ca");
        ICON_MAP.put(TY_PLANE, "\ue0cc");
        ICON_MAP.put(TY_PLANE_OUTLINE, "\ue0cb");
        ICON_MAP.put(TY_PLUG, "\ue0cd");
        ICON_MAP.put(TY_PLUS, "\ue0cf");
        ICON_MAP.put(TY_PLUS_OUTLINE, "\ue0ce");
        ICON_MAP.put(TY_POINT_OF_INTEREST, "\ue0d1");
        ICON_MAP.put(TY_POINT_OF_INTEREST_OUTLINE, "\ue0d0");
        ICON_MAP.put(TY_POWER, "\ue0d3");
        ICON_MAP.put(TY_POWER_OUTLINE, "\ue0d2");
        ICON_MAP.put(TY_PRINTER, "\ue0d4");
        ICON_MAP.put(TY_PUZZLE, "\ue0d6");
        ICON_MAP.put(TY_PUZZLE_OUTLINE, "\ue0d5");
        ICON_MAP.put(TY_RADAR, "\ue0d8");
        ICON_MAP.put(TY_RADAR_OUTLINE, "\ue0d7");
        ICON_MAP.put(TY_REFRESH, "\ue0da");
        ICON_MAP.put(TY_REFRESH_OUTLINE, "\ue0d9");
        ICON_MAP.put(TY_RSS, "\ue0dc");
        ICON_MAP.put(TY_RSS_OUTLINE, "\ue0db");
        ICON_MAP.put(TY_SCISSORS, "\ue0de");
        ICON_MAP.put(TY_SCISSORS_OUTLINE, "\ue0dd");
        ICON_MAP.put(TY_SHOPPING_BAG, "\ue0df");
        ICON_MAP.put(TY_SHOPPING_CART, "\ue0e0");
        ICON_MAP.put(TY_SOCIAL_AT_CIRCULAR, "\ue0e1");
        ICON_MAP.put(TY_SOCIAL_DRIBBBLE, "\ue0e3");
        ICON_MAP.put(TY_SOCIAL_DRIBBBLE_CIRCULAR, "\ue0e2");
        ICON_MAP.put(TY_SOCIAL_FACEBOOK, "\ue0e5");
        ICON_MAP.put(TY_SOCIAL_FACEBOOK_CIRCULAR, "\ue0e4");
        ICON_MAP.put(TY_SOCIAL_FLICKR, "\ue0e7");
        ICON_MAP.put(TY_SOCIAL_FLICKR_CIRCULAR, "\ue0e6");
        ICON_MAP.put(TY_SOCIAL_GITHUB, "\ue0e9");
        ICON_MAP.put(TY_SOCIAL_GITHUB_CIRCULAR, "\ue0e8");
        ICON_MAP.put(TY_SOCIAL_GOOGLE_PLUS, "\ue0eb");
        ICON_MAP.put(TY_SOCIAL_GOOGLE_PLUS_CIRCULAR, "\ue0ea");
        ICON_MAP.put(TY_SOCIAL_INSTAGRAM, "\ue0ed");
        ICON_MAP.put(TY_SOCIAL_INSTAGRAM_CIRCULAR, "\ue0ec");
        ICON_MAP.put(TY_SOCIAL_LAST_FM, "\ue0ef");
        ICON_MAP.put(TY_SOCIAL_LAST_FM_CIRCULAR, "\ue0ee");
        ICON_MAP.put(TY_SOCIAL_LINKEDIN, "\ue0f1");
        ICON_MAP.put(TY_SOCIAL_LINKEDIN_CIRCULAR, "\ue0f0");
        ICON_MAP.put(TY_SOCIAL_PINTEREST, "\ue0f3");
        ICON_MAP.put(TY_SOCIAL_PINTEREST_CIRCULAR, "\ue0f2");
        ICON_MAP.put(TY_SOCIAL_SKYPE, "\ue0f5");
        ICON_MAP.put(TY_SOCIAL_SKYPE_OUTLINE, "\ue0f4");
        ICON_MAP.put(TY_SOCIAL_TUMBLER, "\ue0f7");
        ICON_MAP.put(TY_SOCIAL_TUMBLER_CIRCULAR, "\ue0f6");
        ICON_MAP.put(TY_SOCIAL_TWITTER, "\ue0f9");
        ICON_MAP.put(TY_SOCIAL_TWITTER_CIRCULAR, "\ue0f8");
        ICON_MAP.put(TY_SOCIAL_VIMEO, "\ue0fb");
        ICON_MAP.put(TY_SOCIAL_VIMEO_CIRCULAR, "\ue0fa");
        ICON_MAP.put(TY_SOCIAL_YOUTUBE, "\ue0fd");
        ICON_MAP.put(TY_SOCIAL_YOUTUBE_CIRCULAR, "\ue0fc");
        ICON_MAP.put(TY_SORT_ALPHABETICALLY, "\ue0ff");
        ICON_MAP.put(TY_SORT_ALPHABETICALLY_OUTLINE, "\ue0fe");
        ICON_MAP.put(TY_SORT_NUMERICALLY, "\ue101");
        ICON_MAP.put(TY_SORT_NUMERICALLY_OUTLINE, "\ue100");
        ICON_MAP.put(TY_SPANNER, "\ue103");
        ICON_MAP.put(TY_SPANNER_OUTLINE, "\ue102");
        ICON_MAP.put(TY_SPIRAL, "\ue104");
        ICON_MAP.put(TY_STAR, "\ue109");
        ICON_MAP.put(TY_STAR_FULL_OUTLINE, "\ue105");
        ICON_MAP.put(TY_STAR_HALF, "\ue107");
        ICON_MAP.put(TY_STAR_HALF_OUTLINE, "\ue106");
        ICON_MAP.put(TY_STAR_OUTLINE, "\ue108");
        ICON_MAP.put(TY_STARBURST, "\ue10b");
        ICON_MAP.put(TY_STARBURST_OUTLINE, "\ue10a");
        ICON_MAP.put(TY_STOPWATCH, "\ue10c");
        ICON_MAP.put(TY_SUPPORT, "\ue10d");
        ICON_MAP.put(TY_TABS_OUTLINE, "\ue10e");
        ICON_MAP.put(TY_TAG, "\ue10f");
        ICON_MAP.put(TY_TAGS, "\ue110");
        ICON_MAP.put(TY_TH_LARGE, "\ue112");
        ICON_MAP.put(TY_TH_LARGE_OUTLINE, "\ue111");
        ICON_MAP.put(TY_TH_LIST, "\ue114");
        ICON_MAP.put(TY_TH_LIST_OUTLINE, "\ue113");
        ICON_MAP.put(TY_TH_MENU, "\ue116");
        ICON_MAP.put(TY_TH_MENU_OUTLINE, "\ue115");
        ICON_MAP.put(TY_TH_SMALL, "\ue118");
        ICON_MAP.put(TY_TH_SMALL_OUTLINE, "\ue117");
        ICON_MAP.put(TY_THERMOMETER, "\ue119");
        ICON_MAP.put(TY_THUMBS_DOWN, "\ue11a");
        ICON_MAP.put(TY_THUMBS_OK, "\ue11b");
        ICON_MAP.put(TY_THUMBS_UP, "\ue11c");
        ICON_MAP.put(TY_TICK, "\ue11e");
        ICON_MAP.put(TY_TICK_OUTLINE, "\ue11d");
        ICON_MAP.put(TY_TICKET, "\ue11f");
        ICON_MAP.put(TY_TIME, "\ue120");
        ICON_MAP.put(TY_TIMES, "\ue122");
        ICON_MAP.put(TY_TIMES_OUTLINE, "\ue121");
        ICON_MAP.put(TY_TRASH, "\ue123");
        ICON_MAP.put(TY_TREE, "\ue124");
        ICON_MAP.put(TY_UPLOAD, "\ue126");
        ICON_MAP.put(TY_UPLOAD_OUTLINE, "\ue125");
        ICON_MAP.put(TY_USER, "\ue12c");
        ICON_MAP.put(TY_USER_ADD, "\ue128");
        ICON_MAP.put(TY_USER_ADD_OUTLINE, "\ue127");
        ICON_MAP.put(TY_USER_DELETE, "\ue12a");
        ICON_MAP.put(TY_USER_DELETE_OUTLINE, "\ue129");
        ICON_MAP.put(TY_USER_OUTLINE, "\ue12b");
        ICON_MAP.put(TY_VENDOR_ANDROID, "\ue12d");
        ICON_MAP.put(TY_VENDOR_APPLE, "\ue12e");
        ICON_MAP.put(TY_VENDOR_MICROSOFT, "\ue12f");
        ICON_MAP.put(TY_VIDEO, "\ue131");
        ICON_MAP.put(TY_VIDEO_OUTLINE, "\ue130");
        ICON_MAP.put(TY_VOLUME, "\ue135");
        ICON_MAP.put(TY_VOLUME_DOWN, "\ue132");
        ICON_MAP.put(TY_VOLUME_MUTE, "\ue133");
        ICON_MAP.put(TY_VOLUME_UP, "\ue134");
        ICON_MAP.put(TY_WARNING, "\ue137");
        ICON_MAP.put(TY_WARNING_OUTLINE, "\ue136");
        ICON_MAP.put(TY_WATCH, "\ue138");
        ICON_MAP.put(TY_WAVES, "\ue13a");
        ICON_MAP.put(TY_WAVES_OUTLINE, "\ue139");
        ICON_MAP.put(TY_WEATHER_CLOUDY, "\ue13b");
        ICON_MAP.put(TY_WEATHER_DOWNPOUR, "\ue13c");
        ICON_MAP.put(TY_WEATHER_NIGHT, "\ue13d");
        ICON_MAP.put(TY_WEATHER_PARTLY_SUNNY, "\ue13e");
        ICON_MAP.put(TY_WEATHER_SHOWER, "\ue13f");
        ICON_MAP.put(TY_WEATHER_SNOW, "\ue140");
        ICON_MAP.put(TY_WEATHER_STORMY, "\ue141");
        ICON_MAP.put(TY_WEATHER_SUNNY, "\ue142");
        ICON_MAP.put(TY_WEATHER_WINDY, "\ue144");
        ICON_MAP.put(TY_WEATHER_WINDY_CLOUDY, "\ue143");
        ICON_MAP.put(TY_WI_FI, "\ue146");
        ICON_MAP.put(TY_WI_FI_OUTLINE, "\ue145");
        ICON_MAP.put(TY_WINE, "\ue147");
        ICON_MAP.put(TY_WORLD, "\ue149");
        ICON_MAP.put(TY_WORLD_OUTLINE, "\ue148");
        ICON_MAP.put(TY_ZOOM, "\ue14f");
        ICON_MAP.put(TY_ZOOM_IN, "\ue14b");
        ICON_MAP.put(TY_ZOOM_IN_OUTLINE, "\ue14a");
        ICON_MAP.put(TY_ZOOM_OUT, "\ue14d");
        ICON_MAP.put(TY_ZOOM_OUT_OUTLINE, "\ue14c");
        ICON_MAP.put(TY_ZOOM_OUTLINE, "\ue14e");

        ATTR_MAP.put(0, TY_ADJUST_BRIGHTNESS);
        ATTR_MAP.put(1, TY_ADJUST_CONTRAST);
        ATTR_MAP.put(2, TY_ANCHOR);
        ATTR_MAP.put(3, TY_ANCHOR_OUTLINE);
        ATTR_MAP.put(4, TY_ARCHIVE);
        ATTR_MAP.put(5, TY_ARROW_BACK);
        ATTR_MAP.put(6, TY_ARROW_BACK_OUTLINE);
        ATTR_MAP.put(7, TY_ARROW_DOWN);
        ATTR_MAP.put(8, TY_ARROW_DOWN_OUTLINE);
        ATTR_MAP.put(9, TY_ARROW_DOWN_THICK);
        ATTR_MAP.put(10, TY_ARROW_FORWARD);
        ATTR_MAP.put(11, TY_ARROW_FORWARD_OUTLINE);
        ATTR_MAP.put(12, TY_ARROW_LEFT);
        ATTR_MAP.put(13, TY_ARROW_LEFT_OUTLINE);
        ATTR_MAP.put(14, TY_ARROW_LEFT_THICK);
        ATTR_MAP.put(15, TY_ARROW_LOOP);
        ATTR_MAP.put(16, TY_ARROW_LOOP_OUTLINE);
        ATTR_MAP.put(17, TY_ARROW_MAXIMISE);
        ATTR_MAP.put(18, TY_ARROW_MAXIMISE_OUTLINE);
        ATTR_MAP.put(19, TY_ARROW_MINIMISE);
        ATTR_MAP.put(20, TY_ARROW_MINIMISE_OUTLINE);
        ATTR_MAP.put(21, TY_ARROW_MOVE);
        ATTR_MAP.put(22, TY_ARROW_MOVE_OUTLINE);
        ATTR_MAP.put(23, TY_ARROW_REPEAT);
        ATTR_MAP.put(24, TY_ARROW_REPEAT_OUTLINE);
        ATTR_MAP.put(25, TY_ARROW_RIGHT);
        ATTR_MAP.put(26, TY_ARROW_RIGHT_OUTLINE);
        ATTR_MAP.put(27, TY_ARROW_RIGHT_THICK);
        ATTR_MAP.put(28, TY_ARROW_SHUFFLE);
        ATTR_MAP.put(29, TY_ARROW_SORTED_DOWN);
        ATTR_MAP.put(30, TY_ARROW_SORTED_UP);
        ATTR_MAP.put(31, TY_ARROW_SYNC);
        ATTR_MAP.put(32, TY_ARROW_SYNC_OUTLINE);
        ATTR_MAP.put(33, TY_ARROW_UNSORTED);
        ATTR_MAP.put(34, TY_ARROW_UP);
        ATTR_MAP.put(35, TY_ARROW_UP_OUTLINE);
        ATTR_MAP.put(36, TY_ARROW_UP_THICK);
        ATTR_MAP.put(37, TY_AT);
        ATTR_MAP.put(38, TY_ATTACHMENT);
        ATTR_MAP.put(39, TY_ATTACHMENT_OUTLINE);
        ATTR_MAP.put(40, TY_BACKSPACE);
        ATTR_MAP.put(41, TY_BACKSPACE_OUTLINE);
        ATTR_MAP.put(42, TY_BATTERY_CHARGE);
        ATTR_MAP.put(43, TY_BATTERY_FULL);
        ATTR_MAP.put(44, TY_BATTERY_HIGH);
        ATTR_MAP.put(45, TY_BATTERY_LOW);
        ATTR_MAP.put(46, TY_BATTERY_MID);
        ATTR_MAP.put(47, TY_BEAKER);
        ATTR_MAP.put(48, TY_BEER);
        ATTR_MAP.put(49, TY_BELL);
        ATTR_MAP.put(50, TY_BOOK);
        ATTR_MAP.put(51, TY_BOOKMARK);
        ATTR_MAP.put(52, TY_BRIEFCASE);
        ATTR_MAP.put(53, TY_BRUSH);
        ATTR_MAP.put(54, TY_BUSINESS_CARD);
        ATTR_MAP.put(55, TY_CALCULATOR);
        ATTR_MAP.put(56, TY_CALENDAR);
        ATTR_MAP.put(57, TY_CALENDAR_OUTLINE);
        ATTR_MAP.put(58, TY_CAMERA);
        ATTR_MAP.put(59, TY_CAMERA_OUTLINE);
        ATTR_MAP.put(60, TY_CANCEL);
        ATTR_MAP.put(61, TY_CANCEL_OUTLINE);
        ATTR_MAP.put(62, TY_CHART_AREA);
        ATTR_MAP.put(63, TY_CHART_AREA_OUTLINE);
        ATTR_MAP.put(64, TY_CHART_BAR);
        ATTR_MAP.put(65, TY_CHART_BAR_OUTLINE);
        ATTR_MAP.put(66, TY_CHART_LINE);
        ATTR_MAP.put(67, TY_CHART_LINE_OUTLINE);
        ATTR_MAP.put(68, TY_CHART_PIE);
        ATTR_MAP.put(69, TY_CHART_PIE_OUTLINE);
        ATTR_MAP.put(70, TY_CHEVRON_LEFT);
        ATTR_MAP.put(71, TY_CHEVRON_LEFT_OUTLINE);
        ATTR_MAP.put(72, TY_CHEVRON_RIGHT);
        ATTR_MAP.put(73, TY_CHEVRON_RIGHT_OUTLINE);
        ATTR_MAP.put(74, TY_CLIPBOARD);
        ATTR_MAP.put(75, TY_CLOUD_STORAGE);
        ATTR_MAP.put(76, TY_CLOUD_STORAGE_OUTLINE);
        ATTR_MAP.put(77, TY_CODE);
        ATTR_MAP.put(78, TY_CODE_OUTLINE);
        ATTR_MAP.put(79, TY_COFFEE);
        ATTR_MAP.put(80, TY_COG);
        ATTR_MAP.put(81, TY_COG_OUTLINE);
        ATTR_MAP.put(82, TY_COMPASS);
        ATTR_MAP.put(83, TY_CONTACTS);
        ATTR_MAP.put(84, TY_CREDIT_CARD);
        ATTR_MAP.put(85, TY_CSS3);
        ATTR_MAP.put(86, TY_DATABASE);
        ATTR_MAP.put(87, TY_DELETE);
        ATTR_MAP.put(88, TY_DELETE_OUTLINE);
        ATTR_MAP.put(89, TY_DEVICE_DESKTOP);
        ATTR_MAP.put(90, TY_DEVICE_LAPTOP);
        ATTR_MAP.put(91, TY_DEVICE_PHONE);
        ATTR_MAP.put(92, TY_DEVICE_TABLET);
        ATTR_MAP.put(93, TY_DIRECTIONS);
        ATTR_MAP.put(94, TY_DIVIDE);
        ATTR_MAP.put(95, TY_DIVIDE_OUTLINE);
        ATTR_MAP.put(96, TY_DOCUMENT);
        ATTR_MAP.put(97, TY_DOCUMENT_ADD);
        ATTR_MAP.put(98, TY_DOCUMENT_DELETE);
        ATTR_MAP.put(99, TY_DOCUMENT_TEXT);
        ATTR_MAP.put(100, TY_DOWNLOAD);
        ATTR_MAP.put(101, TY_DOWNLOAD_OUTLINE);
        ATTR_MAP.put(102, TY_DROPBOX);
        ATTR_MAP.put(103, TY_EDIT);
        ATTR_MAP.put(104, TY_EJECT);
        ATTR_MAP.put(105, TY_EJECT_OUTLINE);
        ATTR_MAP.put(106, TY_EQUALS);
        ATTR_MAP.put(107, TY_EQUALS_OUTLINE);
        ATTR_MAP.put(108, TY_EXPORT);
        ATTR_MAP.put(109, TY_EXPORT_OUTLINE);
        ATTR_MAP.put(110, TY_EYE);
        ATTR_MAP.put(111, TY_EYE_OUTLINE);
        ATTR_MAP.put(112, TY_FEATHER);
        ATTR_MAP.put(113, TY_FILM);
        ATTR_MAP.put(114, TY_FILTER);
        ATTR_MAP.put(115, TY_FLAG);
        ATTR_MAP.put(116, TY_FLAG_OUTLINE);
        ATTR_MAP.put(117, TY_FLASH);
        ATTR_MAP.put(118, TY_FLASH_OUTLINE);
        ATTR_MAP.put(119, TY_FLOW_CHILDREN);
        ATTR_MAP.put(120, TY_FLOW_MERGE);
        ATTR_MAP.put(121, TY_FLOW_PARALLEL);
        ATTR_MAP.put(122, TY_FLOW_SWITCH);
        ATTR_MAP.put(123, TY_FOLDER);
        ATTR_MAP.put(124, TY_FOLDER_ADD);
        ATTR_MAP.put(125, TY_FOLDER_DELETE);
        ATTR_MAP.put(126, TY_FOLDER_OPEN);
        ATTR_MAP.put(127, TY_GIFT);
        ATTR_MAP.put(128, TY_GLOBE);
        ATTR_MAP.put(129, TY_GLOBE_OUTLINE);
        ATTR_MAP.put(130, TY_GROUP);
        ATTR_MAP.put(131, TY_GROUP_OUTLINE);
        ATTR_MAP.put(132, TY_HEADPHONES);
        ATTR_MAP.put(133, TY_HEART);
        ATTR_MAP.put(134, TY_HEART_FULL_OUTLINE);
        ATTR_MAP.put(135, TY_HEART_HALF_OUTLINE);
        ATTR_MAP.put(136, TY_HEART_OUTLINE);
        ATTR_MAP.put(137, TY_HOME);
        ATTR_MAP.put(138, TY_HOME_OUTLINE);
        ATTR_MAP.put(139, TY_HTML5);
        ATTR_MAP.put(140, TY_IMAGE);
        ATTR_MAP.put(141, TY_IMAGE_OUTLINE);
        ATTR_MAP.put(142, TY_INFINITY);
        ATTR_MAP.put(143, TY_INFINITY_OUTLINE);
        ATTR_MAP.put(144, TY_INFO);
        ATTR_MAP.put(145, TY_INFO_LARGE);
        ATTR_MAP.put(146, TY_INFO_LARGE_OUTLINE);
        ATTR_MAP.put(147, TY_INFO_OUTLINE);
        ATTR_MAP.put(148, TY_INPUT_CHECKED);
        ATTR_MAP.put(149, TY_INPUT_CHECKED_OUTLINE);
        ATTR_MAP.put(150, TY_KEY);
        ATTR_MAP.put(151, TY_KEY_OUTLINE);
        ATTR_MAP.put(152, TY_KEYBOARD);
        ATTR_MAP.put(153, TY_LEAF);
        ATTR_MAP.put(154, TY_LIGHTBULB);
        ATTR_MAP.put(155, TY_LINK);
        ATTR_MAP.put(156, TY_LINK_OUTLINE);
        ATTR_MAP.put(157, TY_LOCATION);
        ATTR_MAP.put(158, TY_LOCATION_ARROW);
        ATTR_MAP.put(159, TY_LOCATION_ARROW_OUTLINE);
        ATTR_MAP.put(160, TY_LOCATION_OUTLINE);
        ATTR_MAP.put(161, TY_LOCK_CLOSED);
        ATTR_MAP.put(162, TY_LOCK_CLOSED_OUTLINE);
        ATTR_MAP.put(163, TY_LOCK_OPEN);
        ATTR_MAP.put(164, TY_LOCK_OPEN_OUTLINE);
        ATTR_MAP.put(165, TY_MAIL);
        ATTR_MAP.put(166, TY_MAP);
        ATTR_MAP.put(167, TY_MEDIA_EJECT);
        ATTR_MAP.put(168, TY_MEDIA_EJECT_OUTLINE);
        ATTR_MAP.put(169, TY_MEDIA_FAST_FORWARD);
        ATTR_MAP.put(170, TY_MEDIA_FAST_FORWARD_OUTLINE);
        ATTR_MAP.put(171, TY_MEDIA_PAUSE);
        ATTR_MAP.put(172, TY_MEDIA_PAUSE_OUTLINE);
        ATTR_MAP.put(173, TY_MEDIA_PLAY);
        ATTR_MAP.put(174, TY_MEDIA_PLAY_OUTLINE);
        ATTR_MAP.put(175, TY_MEDIA_PLAY_REVERSE);
        ATTR_MAP.put(176, TY_MEDIA_PLAY_REVERSE_OUTLINE);
        ATTR_MAP.put(177, TY_MEDIA_RECORD);
        ATTR_MAP.put(178, TY_MEDIA_RECORD_OUTLINE);
        ATTR_MAP.put(179, TY_MEDIA_REWIND);
        ATTR_MAP.put(180, TY_MEDIA_REWIND_OUTLINE);
        ATTR_MAP.put(181, TY_MEDIA_STOP);
        ATTR_MAP.put(182, TY_MEDIA_STOP_OUTLINE);
        ATTR_MAP.put(183, TY_MESSAGE);
        ATTR_MAP.put(184, TY_MESSAGE_TYPING);
        ATTR_MAP.put(185, TY_MESSAGES);
        ATTR_MAP.put(186, TY_MICROPHONE);
        ATTR_MAP.put(187, TY_MICROPHONE_OUTLINE);
        ATTR_MAP.put(188, TY_MINUS);
        ATTR_MAP.put(189, TY_MINUS_OUTLINE);
        ATTR_MAP.put(190, TY_MORTAR_BOARD);
        ATTR_MAP.put(191, TY_NEWS);
        ATTR_MAP.put(192, TY_NOTES);
        ATTR_MAP.put(193, TY_NOTES_OUTLINE);
        ATTR_MAP.put(194, TY_PEN);
        ATTR_MAP.put(195, TY_PENCIL);
        ATTR_MAP.put(196, TY_PHONE);
        ATTR_MAP.put(197, TY_PHONE_OUTLINE);
        ATTR_MAP.put(198, TY_PI);
        ATTR_MAP.put(199, TY_PI_OUTLINE);
        ATTR_MAP.put(200, TY_PIN);
        ATTR_MAP.put(201, TY_PIN_OUTLINE);
        ATTR_MAP.put(202, TY_PIPETTE);
        ATTR_MAP.put(203, TY_PLANE);
        ATTR_MAP.put(204, TY_PLANE_OUTLINE);
        ATTR_MAP.put(205, TY_PLUG);
        ATTR_MAP.put(206, TY_PLUS);
        ATTR_MAP.put(207, TY_PLUS_OUTLINE);
        ATTR_MAP.put(208, TY_POINT_OF_INTEREST);
        ATTR_MAP.put(209, TY_POINT_OF_INTEREST_OUTLINE);
        ATTR_MAP.put(210, TY_POWER);
        ATTR_MAP.put(211, TY_POWER_OUTLINE);
        ATTR_MAP.put(212, TY_PRINTER);
        ATTR_MAP.put(213, TY_PUZZLE);
        ATTR_MAP.put(214, TY_PUZZLE_OUTLINE);
        ATTR_MAP.put(215, TY_RADAR);
        ATTR_MAP.put(216, TY_RADAR_OUTLINE);
        ATTR_MAP.put(217, TY_REFRESH);
        ATTR_MAP.put(218, TY_REFRESH_OUTLINE);
        ATTR_MAP.put(219, TY_RSS);
        ATTR_MAP.put(220, TY_RSS_OUTLINE);
        ATTR_MAP.put(221, TY_SCISSORS);
        ATTR_MAP.put(222, TY_SCISSORS_OUTLINE);
        ATTR_MAP.put(223, TY_SHOPPING_BAG);
        ATTR_MAP.put(224, TY_SHOPPING_CART);
        ATTR_MAP.put(225, TY_SOCIAL_AT_CIRCULAR);
        ATTR_MAP.put(226, TY_SOCIAL_DRIBBBLE);
        ATTR_MAP.put(227, TY_SOCIAL_DRIBBBLE_CIRCULAR);
        ATTR_MAP.put(228, TY_SOCIAL_FACEBOOK);
        ATTR_MAP.put(229, TY_SOCIAL_FACEBOOK_CIRCULAR);
        ATTR_MAP.put(230, TY_SOCIAL_FLICKR);
        ATTR_MAP.put(231, TY_SOCIAL_FLICKR_CIRCULAR);
        ATTR_MAP.put(232, TY_SOCIAL_GITHUB);
        ATTR_MAP.put(233, TY_SOCIAL_GITHUB_CIRCULAR);
        ATTR_MAP.put(234, TY_SOCIAL_GOOGLE_PLUS);
        ATTR_MAP.put(235, TY_SOCIAL_GOOGLE_PLUS_CIRCULAR);
        ATTR_MAP.put(236, TY_SOCIAL_INSTAGRAM);
        ATTR_MAP.put(237, TY_SOCIAL_INSTAGRAM_CIRCULAR);
        ATTR_MAP.put(238, TY_SOCIAL_LAST_FM);
        ATTR_MAP.put(239, TY_SOCIAL_LAST_FM_CIRCULAR);
        ATTR_MAP.put(240, TY_SOCIAL_LINKEDIN);
        ATTR_MAP.put(241, TY_SOCIAL_LINKEDIN_CIRCULAR);
        ATTR_MAP.put(242, TY_SOCIAL_PINTEREST);
        ATTR_MAP.put(243, TY_SOCIAL_PINTEREST_CIRCULAR);
        ATTR_MAP.put(244, TY_SOCIAL_SKYPE);
        ATTR_MAP.put(245, TY_SOCIAL_SKYPE_OUTLINE);
        ATTR_MAP.put(246, TY_SOCIAL_TUMBLER);
        ATTR_MAP.put(247, TY_SOCIAL_TUMBLER_CIRCULAR);
        ATTR_MAP.put(248, TY_SOCIAL_TWITTER);
        ATTR_MAP.put(249, TY_SOCIAL_TWITTER_CIRCULAR);
        ATTR_MAP.put(250, TY_SOCIAL_VIMEO);
        ATTR_MAP.put(251, TY_SOCIAL_VIMEO_CIRCULAR);
        ATTR_MAP.put(252, TY_SOCIAL_YOUTUBE);
        ATTR_MAP.put(253, TY_SOCIAL_YOUTUBE_CIRCULAR);
        ATTR_MAP.put(254, TY_SORT_ALPHABETICALLY);
        ATTR_MAP.put(255, TY_SORT_ALPHABETICALLY_OUTLINE);
        ATTR_MAP.put(256, TY_SORT_NUMERICALLY);
        ATTR_MAP.put(257, TY_SORT_NUMERICALLY_OUTLINE);
        ATTR_MAP.put(258, TY_SPANNER);
        ATTR_MAP.put(259, TY_SPANNER_OUTLINE);
        ATTR_MAP.put(260, TY_SPIRAL);
        ATTR_MAP.put(261, TY_STAR);
        ATTR_MAP.put(262, TY_STAR_FULL_OUTLINE);
        ATTR_MAP.put(263, TY_STAR_HALF);
        ATTR_MAP.put(264, TY_STAR_HALF_OUTLINE);
        ATTR_MAP.put(265, TY_STAR_OUTLINE);
        ATTR_MAP.put(266, TY_STARBURST);
        ATTR_MAP.put(267, TY_STARBURST_OUTLINE);
        ATTR_MAP.put(268, TY_STOPWATCH);
        ATTR_MAP.put(269, TY_SUPPORT);
        ATTR_MAP.put(270, TY_TABS_OUTLINE);
        ATTR_MAP.put(271, TY_TAG);
        ATTR_MAP.put(272, TY_TAGS);
        ATTR_MAP.put(273, TY_TH_LARGE);
        ATTR_MAP.put(274, TY_TH_LARGE_OUTLINE);
        ATTR_MAP.put(275, TY_TH_LIST);
        ATTR_MAP.put(276, TY_TH_LIST_OUTLINE);
        ATTR_MAP.put(277, TY_TH_MENU);
        ATTR_MAP.put(278, TY_TH_MENU_OUTLINE);
        ATTR_MAP.put(279, TY_TH_SMALL);
        ATTR_MAP.put(280, TY_TH_SMALL_OUTLINE);
        ATTR_MAP.put(281, TY_THERMOMETER);
        ATTR_MAP.put(282, TY_THUMBS_DOWN);
        ATTR_MAP.put(283, TY_THUMBS_OK);
        ATTR_MAP.put(284, TY_THUMBS_UP);
        ATTR_MAP.put(285, TY_TICK);
        ATTR_MAP.put(286, TY_TICK_OUTLINE);
        ATTR_MAP.put(287, TY_TICKET);
        ATTR_MAP.put(288, TY_TIME);
        ATTR_MAP.put(289, TY_TIMES);
        ATTR_MAP.put(290, TY_TIMES_OUTLINE);
        ATTR_MAP.put(291, TY_TRASH);
        ATTR_MAP.put(292, TY_TREE);
        ATTR_MAP.put(293, TY_UPLOAD);
        ATTR_MAP.put(294, TY_UPLOAD_OUTLINE);
        ATTR_MAP.put(295, TY_USER);
        ATTR_MAP.put(296, TY_USER_ADD);
        ATTR_MAP.put(297, TY_USER_ADD_OUTLINE);
        ATTR_MAP.put(298, TY_USER_DELETE);
        ATTR_MAP.put(299, TY_USER_DELETE_OUTLINE);
        ATTR_MAP.put(300, TY_USER_OUTLINE);
        ATTR_MAP.put(301, TY_VENDOR_ANDROID);
        ATTR_MAP.put(302, TY_VENDOR_APPLE);
        ATTR_MAP.put(303, TY_VENDOR_MICROSOFT);
        ATTR_MAP.put(304, TY_VIDEO);
        ATTR_MAP.put(305, TY_VIDEO_OUTLINE);
        ATTR_MAP.put(306, TY_VOLUME);
        ATTR_MAP.put(307, TY_VOLUME_DOWN);
        ATTR_MAP.put(308, TY_VOLUME_MUTE);
        ATTR_MAP.put(309, TY_VOLUME_UP);
        ATTR_MAP.put(310, TY_WARNING);
        ATTR_MAP.put(311, TY_WARNING_OUTLINE);
        ATTR_MAP.put(312, TY_WATCH);
        ATTR_MAP.put(313, TY_WAVES);
        ATTR_MAP.put(314, TY_WAVES_OUTLINE);
        ATTR_MAP.put(315, TY_WEATHER_CLOUDY);
        ATTR_MAP.put(316, TY_WEATHER_DOWNPOUR);
        ATTR_MAP.put(317, TY_WEATHER_NIGHT);
        ATTR_MAP.put(318, TY_WEATHER_PARTLY_SUNNY);
        ATTR_MAP.put(319, TY_WEATHER_SHOWER);
        ATTR_MAP.put(320, TY_WEATHER_SNOW);
        ATTR_MAP.put(321, TY_WEATHER_STORMY);
        ATTR_MAP.put(322, TY_WEATHER_SUNNY);
        ATTR_MAP.put(323, TY_WEATHER_WINDY);
        ATTR_MAP.put(324, TY_WEATHER_WINDY_CLOUDY);
        ATTR_MAP.put(325, TY_WI_FI);
        ATTR_MAP.put(326, TY_WI_FI_OUTLINE);
        ATTR_MAP.put(327, TY_WINE);
        ATTR_MAP.put(328, TY_WORLD);
        ATTR_MAP.put(329, TY_WORLD_OUTLINE);
        ATTR_MAP.put(330, TY_ZOOM);
        ATTR_MAP.put(331, TY_ZOOM_IN);
        ATTR_MAP.put(332, TY_ZOOM_IN_OUTLINE);
        ATTR_MAP.put(333, TY_ZOOM_OUT);
        ATTR_MAP.put(334, TY_ZOOM_OUT_OUTLINE);
        ATTR_MAP.put(335, TY_ZOOM_OUTLINE);
    }

}
