package com.demo.util;

public enum ErrorMessageEnum implements BaseMessage {

    /**
     * 格式錯誤!
     */
    FORMAT_FAIL("格式錯誤"),

    /**
     * 畫面初始化失敗!
     */
    INIT_FAIL("畫面初始化失敗"),

    /**
     * 必填未填
     *
     * @param (欄位名稱)
     */
    REQUIRED_NULL("請填寫 %s"),

    /**
     * 不可為空值
     */
    NOT_EMPTY("%s不可為空值"),

    /**
     * 值有誤
     */
    VAL_ERROR("%s值有誤"),

    /**
     * 長度超過
     *
     * @param (欄位名稱)
     */
    MAX_LENGTH("欄位: %s超過允許上限值"),

    /**
     * 格式有誤
     *
     * @param (欄位名稱)
     */
    FORMAT_ERROR("欄位: %s格式有誤"),

    /**
     * [刪除]按鈕
     *
     * @param (明細序號)
     */
    DELETE_DETAIL("是否刪除第%d筆的明細?"),

    /**
     * [暫存]按鈕-失敗
     */
    TEMP_SAVE_FAIL("暫存失敗"),

    /**
     * [儲存]按鈕-失敗
     */
    SAVE_FAIL("儲存失敗"),

    /**
     * 展延-失敗
     */
    EXTEND_FAIL("展延失敗"),

    /**
     * 工作單送出成功
     *
     * @param (工作單編號)
     */
    WS_SUBMIT_SUCCESS("送出成功。工作單號為%s"),

    /**
     * 申請表單送出成功
     *
     * @param (申請單編號)
     */
    FORM_SUBMIT_SUCCESS("送出成功。申請單編號為%s"),

    /**
     * IAP簽核單送出成功
     *
     * @param (IAP簽核單號)
     */
    FORM_IAP_SUBMIT_SUCCESS("送出成功。IAP單號為%s"),

    /**
     * 待辦-簽核失敗
     */
    FLOW_SIGN_FAIL("簽核失敗"),

    /**
     * 退回失敗
     */
    BACK_FAIL("退回失敗"),

    /**
     * 取得表單失敗
     */
    GET_FORM_FAIL("取得表單失敗"),

    /**
     * 檢視歷程失敗
     */
    VIEW_HISTORY_FAIL("檢視歷程失敗"),

    /**
     * 刪除失敗
     */
    DELETE_FAIL("刪除失敗"),

    /**
     * 取得待辦失敗
     */
    GET_TODOS_FAIL("取得待辦資料失敗"),

    /**
     * 系統錯誤
     */
    SYSTEM_ERROR("系統錯誤"),

    /**
     * 送出失敗
     */
    SUBMIT_FAIL("送出失敗"),

    /**
     * 撤銷失敗
     */
    REVOKE_FAIL("撤銷失敗"),

    /**
     * 返回前一頁失敗
     */
    PREVPAGE_FAIL("返回前一頁失敗"),

    /**
     * 轉導頁面失敗
     */
    REDIRECT_FAIL("轉導頁面失敗"),

    /**
     * 送出變更申請失敗
     */
    SUBMIT_EXE_FAIL("送出變更申請失敗"),

    /**
     * 檔案刪除失敗
     */
    FILE_DEL_FAIL("檔案刪除失敗!"),

    /**
     * 檔案上傳失敗
     */
    UPLOAD_FILE_FAIL("檔案上傳失敗!"),

    /**
     * 檔案過大
     */
    VALIDATE_FILE_SIZE("上傳檔案大小上限為%dMB，請重新上傳"),

    /**
     * 檔名過長
     */
    FILE_NAME_TOO_LONG("檔名超過%d個字"),

    /**
     * 檔名不可含特殊字元
     */
    FILE_NAME_NO_SPECIAL_CHARACTERS("檔案名稱不可含特殊字元%s"),

    /**
     * 上傳檔案類型不符
     */
    FILE_EXTENDSION_INCOMPATIBLE("上傳檔案類型不符"),

    /**
     * 檔案儲存失敗
     */
    FILE_SAVE_FAIL("檔案儲存失敗"),

    /**
     * 檔案還在上傳中
     */
    FILE_UPLOADING("檔案還在上傳中"),

    /**
     * 請選擇上傳檔案
     */
    SELECT_FILE_FAIL("請選擇上傳檔案"),

    /**
     * 專案完工報告必須有上傳檔案，才能送審
     */
    SELECT_FILE_NEED("有上傳檔案，才能送審"),

    /**
     * 檢視失敗
     */
    VIEW_FAIL("檢視失敗"),

    /**
     * 修改失敗
     */
    MODIFY_FAIL("修改失敗"),

    /**
     * 新增失敗
     */
    ADD_FAIL("新增失敗"),

    /**
     * 開啟連結失敗
     */
    OPEN_URL_FAIL("開啟連結失敗"),

    /**
     * 查詢失敗
     */
    QUERY_FAIL("查詢失敗"),

    /**
     * 清除失敗
     */
    CLEAN_FAIL("清除失敗"),

    /**
     * 資料匯出失敗
     */
    EXPORT_FAIL("資料匯出失敗"),

    /**
     * 下載失敗
     */
    DOWNLOAD_FAIL("下載失敗"),

    /**
     * 檔案不存在
     */
    FILE_IS_NOT_EXIST("檔案不存在"),

    /**
     * 併入其他大樓失敗
     */
    MAPPING_OTH_BUILDING_FAIL("併入其他大樓失敗"),

    /**
     * 起日大於迄日
     *
     * @param (欄位名稱)
     */
    STARTDATE_BIG_THEN_ENDDATE("%s起日大於迄日"),

    /**
     * 資料重覆
     */
    DUPLICATE_DATA("資料重覆"),

    /**
     * 資料為空值
     *
     * @param (欄位名稱)
     */
    DATA_EMPTY("欄位: %s資料為空值"),

    /**
     * 長度過長
     *
     * @param (欄位名稱)
     * @param (最大長度)
     */
    VALIDTE_LENGTH("欄位: %s長度超過%d個字"),

    /**
     * 數值過大
     *
     * @param (欄位名稱)
     */
    NUM_TOO_BIG("欄位: %s數值過大"),

    /**
     * 資料初始化失敗!
     */
    DATA_FAIL("資料初始化失敗"),

    /**
     * 請勾選項目
     */
    SELECT_BOX("請勾選項目"),

    /**
     * 關閉失敗
     */
    CLOSE_FAIL("關閉失敗"),

    /**
     * 送出通知失敗
     */
    SEND_MAIL_FAIL("送出通知失敗"),

    /**
     * 必選未選
     *
     * @param (欄位名稱)
     */
    SELECT_NULL("請選擇%s"),

    SELECT_NOT_NULL("%s不可為空"),

    /**
     * %s必須晚於%s
     */
    STARTDATE_AFTER_ENDDATE_ARG2("%s必須晚於%s"),

    /**
     * %s必須大於%s
     */
    IS_BIGGER_THAN_ARG2("%s必須大於%s"),

    /**
     * 同站台已有變更中的工作單，不可申請
     */
    HAS_IN_PROCESS_SITECODE("同站台已有變更中的工作單，不可申請"),

    /**
     * 頁籤轉換失敗
     */
    TAB_CHANGE_FAIL("頁籤轉換失敗"),

    /**
     * 值不存在
     */
    KEY_NOT_EXIST_ARG1("欄位: %s不存在"),

    /**
     * 匯入失敗
     */
    IMPORT_FAIL("匯入失敗"),

    /**
     * 批次執行失敗.
     */
    BATCH_EXEC_FAIL("批次執行失敗"),

    /**
     * 發佈失敗
     */
    ENABLED_FAIL("發佈失敗"),

    /**
     * 停用失敗
     */
    DISABLED_FAIL("停用失敗"),

    /**
     * 終止失敗
     */
    TERMINATE_FAIL("終止失敗"),

    /**
     * 寫入AuditLog失敗
     */
    AUDIT_LOG_FAIL("寫入AuditLog失敗"),

    /**
     * 格式非字串.
     */
    CELL_NOT_STRING("欄位: %s格式有誤，必須為文字"),

    /**
     * %s的%s必須晚於%s
     */
    STARTDATE_AFTER_ENDDATE_ARG3("%s的%s必須晚於%s"),

    /**
     * 註冊失敗.
     */
    REGISTER_FAIL("註冊失敗"),

    /**
     * 登入失敗.
     */
    LOGIN_FAIL("登入失敗"),

    /**
     * 登出失敗.
     */
    LOGOUT_FAIL("登出失敗"),

    /**
     * 驗證失敗.
     */
    AUTH_FAIL("驗證失敗"),

    /**
     * 使用者不存在.
     */
    ACCOUNT_NOT_EXIST("使用者%s不存在"),

    /**
     * 分頁元件啟動失敗.
     */
    PAGE_FAIL("分頁元件啟動失敗"),

    /**
     * 按鈕初始化失敗.
     */
    BTN_INIT_FAIL("按鈕初始化失敗"),

    /**
     * Menu初始化失敗
     */
    MENU_FAIL("%s 不存在，Menu初始化失敗"),

    /**
     * RESTful API失敗.
     */
    REST_FAIL("RESTful API失敗"),

    /**
     * On-net項目 [FTTB, Semi-OnNet, FTTB: Fiber-only, Wireless] 只能選擇一項
     */
    MULTISELECT_IN_FTTB_GROUP("On-net項目 %s 不可同時選取"),

    /**
     * On-net 勾選FTTB: Fiber-only時，不可有設備，確認是否仍要勾選，並移除所以已新增的設備
     */
    FIBERONLY_AND_EQUIP_CHECK(
            "勾選FTTB: Fiber-only時，不可新增設備。若勾選，將移除已新增的設備，請確認是否勾選?"),

    /**
     * On-net 勾選FTTB: Fiber-only時，不可有設備，確認是否仍要勾選，並移除所以已新增的設備
     */
    FIBERONLY_AND_EQUIP_NOTICE("勾選FTTB: Fiber-only時，不可新增設備。"),

    /**
     * CTTB upgrade 為 FTTB 時，若 CTTB 勾選被拿掉，需提醒
     */
    CTTB_UPGRADE_TO_FTTB_POPUP("由CTTB升級至FTTB，已取消On-net項目中的CTTB選項"),

    /**
     * 母站資料不存在
     */
    FTTB_VALIDATE_FAIL("母站資料不存在"),

    /**
     * 銅纜引出站台不存在
     */
    CTTB_VALIDATE_FAIL("銅纜引出站台不存在"),

    /**
     * 此銅纜引出站台已是其他母站的子站
     */
    CTTB_ISCHILD_FAIL("此銅纜引出站台已是其他母站的子站"),

    /**
     * 更換負責人失敗
     */
    CHANGE_PRINCIPAL_FAIL("更換負責人失敗"),

    /**
     * 請選擇站台
     */
    SELECT_SITE_EMPTY_FAIL("請選擇站台"),

    /**
     * 請選擇大樓
     */
    SELECT_BUILDING_EMPTY_FAIL("請選擇大樓"),

    /**
     * 請選擇可供裝服務地址
     */
    SELECT_ADDR_SUPPLY_EMPTY_FAIL("請選擇可供裝服務地址"),

    /**
     * 不符合可選站台，請重新選取
     */
    SELECT_SITE_VALIDATE_FAIL("不符合可選站台，請重新選取！"),

    /**
     * 不符合可選站台：%s，請重新選取！
     */
    SELECT_SITE_VALIDATE_FAIL_FORMAT("不符合可選站台：%s，請重新選取！"),

    /**
     * 查無資料
     */
    NO_DATA("查無資料"),

    /**
     * 資料若有異動將不儲存，確認是否取消?
     */
    EXIT_EDIT_FORM("資料若有異動將不儲存，請確認是否取消?"),

    /**
     * [取消]按鈕-失敗
     */
    CANCEL_FAIL("取消失敗"),

    DATE_USE_NO_DELETE("該資料已被使用，不可刪除"),

    FL_EQUIP_DEF_IS_EXIST("此設備資料已存在"),

    BUILDING_NO_IS_NOT_EXIST("此大樓編號不存在，請重新輸入"),

    BUILDING_NO_IS_EMPTY("請輸入大樓編號"),

    BUILDING_ADDR_IS_DUPLICATED("大樓地址重複"),

    BUILDING_ADDR_IS_EMPTY("缺少大樓地址"),

    /**
     * 計算最高簽核層級失敗，失敗簽核單號： %s
     */
    WIAP_CAL_FAIL("計算最高簽核層級失敗，失敗簽核單號： %s"),

    /**
     * 計算最高簽核層級失敗，失敗單號： %s
     */
    WIAP_CAL_SUCCESS("計算成功，最高簽核層級為： %s"),

    /**
     * 無須規劃書，不可新增設備
     */
    NONEEDPLAN_AND_EQUIP_NOTICE("勾選無須規劃書時，不可新增設備。"),

    /**
     * 勾選無須規劃書時，不可新增設備。若勾選，將移除已新增的設備，請確認是否勾選?
     */
    NONEEDPLAN_AND_EQUIP_CHECK(
            "勾選無須規劃書時，不可新增設備。若勾選，將移除已新增的設備，請確認是否勾選?"),

    /**
     * 異動類型為同大樓搬遷(需求不變更)時，不可新增客戶申裝需求設備。
     */
    SALESAPPLY_AND_EQUIP_NOTICE("異動類型為同大樓搬遷(需求不變更)時，不可新增客戶申裝需求設備。"),

    /**
     * 異動類型為同大樓搬遷(需求不變更)時，不可新增客戶申裝需求設備。若勾選，將移除已新增的設備，請確認是否勾選?
     */
    SALESAPPLY_AND_EQUIP_CHECK(
            "異動類型為同大樓搬遷(需求不變更)時，不可新增客戶申裝需求設備。若勾選，將移除已新增的設備，請確認是否勾選?"),

    /**
     * 信件標題-帶入sitecode用
     */
    MAIL_TITLE_SITECODE("-SiteCode(%s)"),

    /**
     * Site Code 不存在
     */
    SITE_CODE_IS_NOT_EXIST("Site Code 不存在"),

    /**
     * 系統參數異常
     */
    PARAM_ERROR("系統參數異常，MainCode:"),

    /**
     * 請選擇角色
     */
    SELECT_ROLE("請選擇角色"),

    /**
     * The incorrect type.
     */
    INCORRECT_TYPE("Incorrect Type : %s"),

    /**
     * 取消失敗
     */
    CANCEL_TYPE("取消失敗"),

    /**
     * 可供裝服務地址至少要有一筆資料
     */
    SITE_INFO_ADDR_ON_DATA("可供裝服務地址至少要有一筆資料"),

    /**
     * 是否確認併入此大樓?
     */
    MERGE_BUILDING("是否確認併入此大樓?"),

    ;

    private String value;

    private ErrorMessageEnum(String value) {
        this.value = value;
    }

    @Override
    public String getTitle() {
        return "錯誤訊息";
    }

    @Override
    public String getValue() {
        return value;
    }

    /**
     * Gets the message.
     *
     * @param param the param
     * @param val   the val
     * @return the message
     */
    public static String getMessage(BaseMessage param, Object... val) {
        return String.format(param.getValue(), val);
    }
}
