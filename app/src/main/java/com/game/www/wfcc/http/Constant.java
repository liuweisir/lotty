package com.game.www.wfcc.http;


public class Constant {

    public static final String ServiceUrl = "http://192.168.2.130:8071/Mobile/";
    public static final String GeneralService = "General/GeneralService.svc/";
    public static final String GeneralLoginByPhoneNum = "GeneralLoginByPhoneNum";
    public static final String GeneralLoginByUsername = "GeneralLoginByUsername";
    public static final String GeneralGetPhoneCode = "GeneralGetPhoneCode";
    public static final String GeneralBindPhoneNumCheck = "GeneralBindPhoneNumCheck";
    public static final String GeneralBindPhoneNum = "GeneralBindPhoneNum";
    public static final String GeneralLogout = "GeneralLogout";
    public static final String GeneralChangePwd = "GeneralChangePwd";
    public static final String AddFileRecords = "AddFileRecords";
    public static final String GetFileRecordToken = "GetFileRecordToken";
    public static final String DeleteFileRecord = "DeleteFileRecord";
    public static final String SelectFileRecord = "SelectFileRecord";
    public static final String ModifyFileRecord = "ModifyFileRecord";


    public static final String AliYunUrl = "http://lanting-storager.img-cn-hangzhou.aliyuncs.com/";
    public static final String AliImageUrl = "http://img-cn-hangzhou.aliyuncs.com";
    public static final String AliVideoUrl = "http://oss-cn-hangzhou.aliyuncs.com";


    public static final String OrgService = "Organization/OrgService.svc/";
    public static final String AddrBookAddCollection = "AddrBookAddCollection";//添加收藏联系人
    public static final String AddrBookCancelCollection = "AddrBookCancelCollection";//取消收藏联系人
    public static final String AddrBookSelectCollection = "AddrBookSelectCollection";//查询用户收藏联系人
    public static final String AddrBookSelectByID = "AddrBookSelectByID";//查询公司或部门的子部门
    public static final String AddrBookSelectByUser = "AddrBookSelectByUser";// 查询员工隶属公司或部门
    public static final String AddrBookSelect = "AddrBookSelect";//使用关键字查询用户联系人 条件包括：姓名、公司短号
    public static final String AddrBookSelectDetail = "AddrBookSelectDetail";//查询联系人详情


    public static final String CustomerService = "Customer/CustomerService.svc/";
    public static final String BuildSelectMobile = "BuildSelectMobile";
    public static final String MeetCustIntentLevel = "MeetCustIntentLevel";
    public static final String MeetCustSource = "MeetCustSource";
    public static final String StaffPosSelect = "StaffPosSelect";
    public static final String MeetCustMobileAddNew = "MeetCustMobileAddNew";
    public static final String MeetCustMobileSelect = "MeetCustMobileSelect";
    public static final String MeetCustMobileDetail = "MeetCustMobileDetail";
    public static final String MeetCustFollowAddNew = "MeetCustFollowAddNew";
    public static final String DesignChange = "DesignChange";
    public static final String MeetCustRemarkNoIntent = "MeetCustRemarkNoIntent";
    public static final String MeetCustActivation = "MeetCustActivation";
    public static final String MeetCustDelete = "MeetCustDelete";
    public static final String MeetCustModify = "MeetCustModify";
    public static final String MeetCustFollowDetail = "MeetCustFollowDetail";
    public static final String DesignChangeDetail = "DesignChangeDetail";


    public static final String ContractService = "Contract/ContractService.svc/";
    public static final String ContractAdd = "ContractAdd";//合同新建
    public static final String ContractChange = "ContractChange";// 合同改签
    public static final String PackageCatgSelectList = "PackageCatgSelectList";
    public static final String ContractSelectDetaile = "ContractSelectDetaile";
    public static final String ContractSelectList = "ContractSelectList";
    public static final String ContractDelete = "ContractDelete";
    public static final String ContractEdit = "ContractEdit";
    public static final String SelectContRefundDetail = "SelectContRefundDetail";


    public static final String ContStartAdd = "ContStartAdd";
    public static final String ContStartDelete = "ContStartDelete";
    public static final String ContStartEdit = "ContStartEdit";
    public static final String ContStartSelectList = "ContStartSelectList";
    public static final String ContStartSelectSingle = "ContStartSelectSingle";


    public static final String SaveContHydropower = "SaveContHydropower";
    public static final String SelectContHydropower = "SelectContHydropower";
    public static final String SelectContHydropowerDetail = "SelectContHydropowerDetail";
    public static final String DeleteContHydropower = "DeleteContHydropower";


    public static final String MyWorkService = "MyWork/MyWorkService.svc/";
    public static final String LeaveAddNew = "LeaveAddNew";
    public static final String LeaveDelete = "LeaveDelete";
    public static final String LeaveModify = "LeaveModify";
    public static final String LeaveSelect = "LeaveSelect";
    public static final String LeaveSelectDetailMobile = "LeaveSelectDetailMobile";

    public static final String EgressAddNew = "EgressAddNew";
    public static final String EgressDelete = "EgressDelete";
    public static final String EgressModify = "EgressModify";
    public static final String EgressSelect = "EgressSelect";
    public static final String EgressSelectDetailMobile = "EgressSelectDetailMobile";

    public static final String CheckBindPhone = "CheckBindPhone";
    public static final String BindPhoneAddNew = "BindPhoneAddNew";
    public static final String BindPhoneChgAddNew = "BindPhoneChgAddNew";
    public static final String SignInOutAddNew = "SignInOutAddNew";
    public static final String CheckSign = "CheckSign";

    public static final String NoticeSelectMobile = "NoticeSelectMobile";
    public static final String NoticeCount = "NoticeCount";
    public static final String NoticeSelectDetailMobile = "NoticeSelectDetailMobile";
    public static final String NoticeReplyAddNew = "NoticeReplyAddNew";


    public static final String WorkflowService = "Workflow/WorkflowService.svc/";

    public static final String FlowStart = "FlowStart";
    public static final String FlowAbort = "FlowAbort";
    public static final String FlowAdopt = "FlowAdopt";
    public static final String FlowBack = "FlowBack";
    public static final String FlowDelegate = "FlowDelegate";
    public static final String FlowViewCopy = "FlowViewCopy";
    public static final String FlowLogSelectDetail = "FlowLogSelectDetail";
    public static final String FlowWaitHandleSelect = "FlowWaitHandleSelect";
    public static final String FlowHandledSelect = "FlowHandledSelect";
    public static final String FlowSelectWaitHandleCount = "FlowSelectWaitHandleCount";
    public static final String SelectMyFlowLog = "SelectMyFlowLog";


    public static final String SiteService = "Site/SiteService.svc/";
    public static final String SelectSiteAcpt = "SelectSiteAcpt";//查询工地验收单
    public static final String SelectSiteAcptByContID = "SelectSiteAcptByContID";//查询一个工地的所有验收单
    public static final String SelectSiteAcptDetail = "SelectSiteAcptDetail";//查询工地验收单详情
    public static final String SelectSiteWaitAcpt = "SelectSiteWaitAcpt";//	 查询工地待验收的验收单
    public static final String FillSpecialRemark = "FillSpecialRemark";
    public static final String AddAcpt = "AddAcpt";
    public static final String SelectMyAcpt = "SelectMyAcpt";
    public static final String SelectAcptDetail = "SelectAcptDetail";
    public static final String SelectAcptHst = "SelectAcptHst";
    public static final String CompleteAcpt = "CompleteAcpt";
    public static final String AddCheckHouseAcptByCont = "AddCheckHouseAcptByCont";
    public static final String SelectMyCheckHouseAcpt = "SelectMyCheckHouseAcpt";
    public static final String CancelAcptByID = "CancelAcptByID";
    public static final String DeleteAcptByID = "DeleteAcptByID";
    public static final String AddRectify = "AddRectify";
    public static final String ModifyRectify = "ModifyRectify";
    public static final String SelectRectifyer = "SelectRectifyer";
    public static final String SelectRectifyDetail = "SelectRectifyDetail";
    public static final String SelectMyRectify = "SelectMyRectify";
    public static final String SelectRectifyHst = "SelectRectifyHst";
    public static final String CompleteRectify = "CompleteRectify";


    public static final String SelectMySite = "SelectMySite";
    public static final String SelectSiteDetail = "SelectSiteDetail";
    public static final String SelectProj = "SelectProj";
    public static final String ModifyPlan = "ModifyPlan";
    public static final String AddPlan = "AddPlan";
    public static final String DeletePlan = "DeletePlan";
    public static final String SelectPlanBySiteID = "SelectPlanBySiteID";
    public static final String StartPlan = "StartPlan";
    public static final String SelectPlanDetail = "SelectPlanDetail";
    public static final String SelectMyWorker = "SelectMyWorker";
    public static final String SelectWorkerDetail = "SelectWorkerDetail";
    public static final String ModifyWorker = "ModifyWorker";
    public static final String DeleteWorker = "DeleteWorker";
    public static final String AddWorker = "AddWorker";


    public static final String AddMatlNeed = "AddMatlNeed";
    public static final String ModifyMatlNeed = "ModifyMatlNeed";
    public static final String SelectMatlNeeds = "SelectMatlNeeds";
    public static final String SelectMatlNeedDetail = "SelectMatlNeedDetail";
    public static final String DeleteMatlNeed = "DeleteMatlNeed";
    public static final String ConfirmMatlNeed = "ConfirmMatlNeed";


    public static final String SelectMatlPurs = "SelectMatlPurs";
    public static final String SelectPurDetail = "SelectPurDetail";
    public static final String AcceptPurMatl = "AcceptPurMatl";
    public static final String CompleteMeasure = "CompleteMeasure";
    public static final String NoticeDeliveryOrInstall = "NoticeDeliveryOrInstall";
    public static final String NoticeMeasure = "NoticeMeasure";

    public static final String FillWorkerSalarySelect = "FillWorkerSalarySelect";
    public static final String FillWorkerSalary = "FillWorkerSalary";


    public static final String CompletePlan = "CompletePlan";
    public static final String CancelPlan = "CancelPlan";


    public static final String AddStopRst = "AddAndSubmitStopRst";
    public static final String SiteRestart = "SiteRestart";
    public static final String SelectMyStopRst = "SelectMyStopRst";
    public static final String SelectStopRstDetail = "SelectStopRstDetail";

    public static final String OfficeService = "Office/OfficeService.svc/";
    public static final String SelectOffcGoodsApplyDetail = "SelectOffcGoodsApplyDetail";

    public static final String AddSiteCmplSelect = "AddSiteCmplSelect";
    public static final String AddSiteCmpl = "AddSiteCmpl";
    public static final String ModifySiteCmpl = "ModifySiteCmpl";
    public static final String SelectCmplDetail = "SelectCmplDetail";
    public static final String DeleteSiteCmpl = "DeleteSiteCmpl";
    public static final String SelectMyCmpl = "SelectMyCmpl";


    public static final String SupplierActService = "Supplier/SupplierActService.svc/";
    public static final String SelectSupplierActDetail = "SelectSupplierActDetail";

    public static final String AddNotepad = "AddNotepad";
    public static final String ModifyNotepad = "ModifyNotepad";
    public static final String SelectNewstNotepad = "SelectNewstNotepad";
    public static final String SelectNotepad = "SelectNotepad";
    public static final String DeleteNotepad = "DeleteNotepad";
    public static final String SelectNotepadDetail = "SelectNotepadDetail";


    public static final String RwdPuhSupplierService = "RwdPuhSupplier/RwdPuhSupplierService.svc/";
    public static final String SelectRwdPuhSupplierDetail = "SelectRwdPuhSupplierDetail";
    public static final String SelectStaffRwdPuh = "SelectStaffRwdPuh";
    public static final String SelectStaffRwdPuhDetail = "SelectStaffRwdPuhDetail";



    public static final String SelectAtnd = "SelectAtnd";
    public static final String SelectAtndDetl = "SelectAtndDetl";
    public static final String ReCalculateExcp = "ReCalculateExcp";

    public static final String SelectStfAcct = "SelectStfAcct";
    public static final String SelectStfAcctChg = "SelectStfAcctChg";
    public static final String AddStfAcct = "AddStfAcct";

    public static final String SelectStaffDetail = "SelectStaffDetail";


    public static final String SelectLiaisonTypeForUse = "SelectLiaisonTypeForUse";
    public static final String AddLiaison = "AddLiaison";
    public static final String ModifyLiaison = "ModifyLiaison";
    public static final String SelectLiaisonsForMobile = "SelectLiaisonsForMobile";
    public static final String SelectLiaisonByID = "SelectLiaisonByID";
    public static final String DeleteLiaison = "DeleteLiaison";
    public static final String ReplyLiaison = "ReplyLiaison";

    public static final String ContractNormalSelectList = "ContractNormalSelectList";

    public static final String SelectCheckHouse = "SelectCheckHouse";
    public static final String SaveCheckHouse = "SaveCheckHouse";
    public static final String DeleteCheckHouse = "DeleteCheckHouse";
    public static final String SelectCheckHouseDetail = "SelectCheckHouseDetail";


    public static final String SelectCheckHouseRefund = "SelectCheckHouseRefund";
    public static final String SelectCheckHouseRefundDetail = "SelectCheckHouseRefundDetail";
    public static final String SaveCheckHouseRefund = "SaveCheckHouseRefund";
    public static final String DeleteCheckHouseRefund = "DeleteCheckHouseRefund";

    public static final String SelectEarnest = "SelectEarnest";
    public static final String SelectEarnestDetail = "SelectEarnestDetail";
    public static final String SaveEarnest = "SaveEarnest";
    public static final String DeleteEarnest = "DeleteEarnest";

    public static final String SelectEarnestRefund = "SelectEarnestRefund";
    public static final String SelectEarnestRefundDetail = "SelectEarnestRefundDetail";
    public static final String SaveEarnestRefund = "SaveEarnestRefund";
    public static final String DeleteEarnestRefund = "DeleteEarnestRefund";

    public static final String SelectFundApplyAndDetlsByID = "SelectFundApplyAndDetlsByID";
    public static final String FundApplyService = "FundApply/FundApplyService.svc/";

    public static final String FundUseApplyService = "FundUseApply/FundUseApplyService.svc/";
    public static final String SelectFundUseApplyAndDetlsByID = "SelectFundUseApplyAndDetlsByID";

    public static final String FinSettleOtherService = "FinSettleOther/FinSettleOtherService.svc/";
    public static final String GetFinSettleOtherInByID = "GetFinSettleOtherInByID";
    public static final String GetFinSettleOtherOutByID = "GetFinSettleOtherOutByID";

    public static final String FinRequestService = "FinRequest/FinRequestService.svc/";
    public static final String GetFinRequestByID = "GetFinRequestByID";
    public static final String ConfirmTransfer = "ConfirmTransfer";
    public static final String SelectFinRequest = "SelectFinRequest";


    public static final String AfterSaleService = "AfterSale/AfterSaleService.svc/";
    public static final String SelectAfterSaleCostDisburseByID = "SelectAfterSaleCostDisburseByID";
    public static final String SelectAfterSaleCostProceedsByID = "SelectAfterSaleCostProceedsByID";

    public static final String SaveOnDutyMode = "SaveOnDutyMode";
    public static final String SelectOnDutyModeList = "SelectOnDutyModeList";
    public static final String SelectOnDutyModeDetail = "SelectOnDutyModeDetail";
    public static final String DeleteOnDutyMode = "DeleteOnDutyMode";

    public static final String SelectBoardroomApplyDetail = "SelectBoardroomApplyDetail";

    public static final String SalarySercvice = "Salary/SalaryService.svc/";
    public static final String SelectSalAdjustDetail = "SelectSalAdjustDetail";

    public static final String SaveOffLeave = "SaveOffLeave";
    public static final String SelectOffLeaveList = "SelectOffLeaveList";
    public static final String SelectOffLeaveDetail = "SelectOffLeaveDetail";
    public static final String DeleteOffLeave = "DeleteOffLeave";
    public static final String SelectChgDateStateByStf = "SelectChgDateStateByStf";

    public static final String SelectCustPromCostDetail= "SelectCustPromCostDetail";

    public static final String SelectCustPromReimburseDetail = "SelectCustPromReimburseDetail";
}