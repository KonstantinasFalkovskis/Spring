package com.klix.tests.backend.tests;

import com.klix.tests.backend.config.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class UserController extends BaseTest {

//    private Long createdUserId;
//
//    private Integer workspaceId;
//
//    @Value("${credentials.token}")
//    private String token;
//
//    @Value("${api.services}")
//    private String baseUrl;
//
//    private String path = "/v1/clients/webusers/";
//
//    private Long clientId;
////    private Long userId;
////    private String setupUserContextAsString;
////    private Long serviceProviderId;
////    private Long objectId;
//
//    @BeforeClass
//    public void prepareTestData() {
////        UserResponse setupUserResponse = dataPreparation.createTestUser(setupClient.getId());
//        clientId = setupClient.getId();
////        userId = setupUserResponse.getId();
//////        databaseUser.validateUserEmail(userId);
////       setupUserContextAsString = UserUtils.userContextAsString(clientId, userId);
////        serviceProviderId = Long.valueOf(SpringApplicationContext.getProperty("serviceProvider.tt2-id"));
//////        objectId =  objectUtils.createObjectGetId("984984985984", clientId);
//    }
//
//    @AfterClass
//    public void cleanObjects() {
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers")
//    @Step("Get")
//    @Issue("QC-85")
//    public void findClientWebusers() {
//        Response response = userService.reqClientWebuser(v20160617, clientId)
//                .get();
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers")
//    @Step("Create")
//    @Issue("QC-85")
//    public void create() {
////        HashMap<String, Object> queryparams = new HashMap<>();
////        queryparams.put("workspace_name", NAME);
//        WorkspacesResponse response = userService.reqClientWebuser(baseUrl, path, token)
////                .queryParameters(queryparams)
//                .body(NEW_WORKSPACE)
//                .postReturnItem(WorkspacesResponse.class);
//        workspaceId = response.getWorkspace_id();
//        assertThat(response.getWorkspace_id()).isNotNull();
//    }
//
//    @Test(dependsOnMethods = {"create"})
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers/{webuserId}")
//    @Step("Delete")
//    @Issue("QC-85")
//    public void delete() {
//        userService.reqClientWebuser(v20160617, clientId, createdUserId, setupUserContextAsString)
//                .statusCode(HttpStatus.SC_NO_CONTENT)
//                .contentType("")
//                .delete();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers/{webuserId}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnWebuserByGivenWebuserId() {
//        UserResponse response = userService.reqClientWebuser(v20160617, clientId, userId, setupUserContextAsString)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers/{webuserId}")
//    @Step("Update")
//    @Issue("QC-85")
//    public void updateWebuser() {
//        UserResponse response = userService.reqClientWebuser(v20160617, clientId, userId, setupUserContextAsString)
//                .body(USER_SETUP)
//                .putReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers/{webuserId}/regional-settings")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsRegionalSettingsForGivenWebuserIdAndClientId() {
//        UserResponse response = userService.reqClientWebuser(v20160617, clientId, userId, setupUserContextAsString)
//                .path("/regional-settings")
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients/{clientId}/webusers/{webuserId}/regional-settings")
//    @Step("Update")
//    @Issue("QC-85")
//    public void updateRegionalDettingsForGivenWebuserId() {
//        UserResponse response = userService.reqClientWebuser(v20160617, clientId, userId, setupUserContextAsString)
//                .path("/regional-settings")
//                .body(USER_SETUP)
//                .putReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers")
//    @Step("Get")
//    @Issue("QC-85")
//    public void findWebusers() {
//        List<UserResponse> response = userService.reqClientWebuser(v20160617, clientId, setupUserContextAsString)
//                .getReturnList(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/by-email-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByEmailAndPassword() {
//        UserResponse response = userService.regWebuser(v20160617, setupUserContextAsString)
//                .path("/by-email-and-password")
//                .queryParameter("email", EMAIL)
//                .queryParameter("password", SETUP_USERNAME)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/by-public-api-key/{keyString}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByPublicApiKey() {
////        String publicApiKey = userUtils.generatePublicApiKey(userId, setupUserContextAsString);
//        UserResponse response = userService.regWebuser(v20160617, setupUserContextAsString)
////                .path("/by-public-api-key/" + publicApiKey)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/by-username-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndPassword() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("password", SETUP_USERNAME);
//        UserResponse response = userService.regWebuser(
//                v20160617, setupUserContextAsString)
//                .path("/by-username-and-password")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/by-username-and-password-and-service-provider-id")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndPasswordAndServiceProviderId() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("password", SETUP_USERNAME);
//        queryparams.put("serviceProviderId", serviceProviderId);
//        UserResponse response = userService.regWebuser(
//                v20160617, setupUserContextAsString)
//                .path("/by-username-and-password-and-service-provider-id")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/by-username-and-service-provider-id")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndServiceProviderId() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("serviceProviderId", serviceProviderId);
//        UserResponse response = userService.regWebuser(
//                v20160617, setupUserContextAsString)
//                .path("/by-username-and-service-provider-id")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/webusers/{webuserId}/regional-settings")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsRegionalSettingsForGivenWebuserId() {
//        UserResponse response = userService.regWebuser(
//                v20160617, userId, setupUserContextAsString)
//                .path("/regional-settings")
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    //bus perdarytas, kai Regimantas pabaigs Object CRUD
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20170711/clients/{clientId}/objects/{objectId}/user-ids-by-object")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getsWebuserIdsByObjectId() {
//        Response response = userService.reqClient(
//                v20170711, clientId,
//                setupUserContextAsString
//        )
//                .path("/objects/" + objectId + "/user-ids-by-object")
//                .get();
//        assertThat(response).isNotNull();
//    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/address-settings")
////    @Step("Get")
////    @Issue("QC-85")
////    public void getAddressSettingsForGivenWebuserId() {
////        AddressSettingsResponse response = userService.reqClientWebuser(
////                v20170711, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/address-settings")
////                .getReturnItem(AddressSettingsResponse.class);
////        assertThat(response).isNotNull();
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/address-settings")
////    @Step("Update")
////    @Issue("QC-85")
////    public void updateAddressSettingsForGivenWebuserId() {
////        AddressSettingsResponse response = userService.reqClientWebuser(
////                v20170711, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/address-settings")
////                .body(ADDRESS_SETTINGS_DATA)
////                .putReturnItem(AddressSettingsResponse.class);
////        assertThat(response).isNotNull();
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/settings")
////    @Step("Get")
////    @Issue("QC-85")
////    public void returnsUserSettingsForGivenWebuserId() {
////        UserSettingsResponse userSettingsResponse = userService.reqClientWebuser(
////                v20170711, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/settings")
////                .getReturnItem(UserSettingsResponse.class);
////        assertThat(userSettingsResponse).isNotNull();
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/settings")
////    @Step("Update")
////    @Issue("QC-85")
////    public void updatesWebUserSettingsForGivenWebuserId() {
////        UserSettingsResponse userSettingsResponse = userService.reqClientWebuser(
////                v20170711, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/settings")
////                .body(USER_SETTINGS_DATA)
////                .putReturnItem(UserSettingsResponse.class);
////        assertThat(userSettingsResponse).isNotNull();
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/tacho-settings")
////    @Step("Get")
////    @Issue("QC-85")
////    public void getTachoSettingsForGivenWebuserId() {
////        addUserSettings();
////        TachoSettingsResponse tachoSettingsResponse = userService.reqClientWebuser(
////                v20170711, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/tacho-settings")
////                .getReturnItem(TachoSettingsResponse.class);
////        assertThat(tachoSettingsResponse).isNotNull();
////    }
//
////    @Step("Add user settings")
////    private void addUserSettings() {
////        userService.reqClientUser(
////                v20190307, clientId, userId,
////                setupUserContextAsString
////        )
////                .path("/settings")
////                .body(new UserSettingsRequest())
////                .putReturnItem(UserSettingsResponse.class);
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/clients/{clientId}/webusers/{webuserId}/webuser-with-settings")
////    @Step("Get")
////    @Issue("QC-85")
////    public void returnsUserWithSettings() {
////        UserObjectResponse userObjectResponse =
////                userService.reqClientWebuser(
////                        v20170711, clientId, userId,
////                        setupUserContextAsString
////                )
////                        .path("/webuser-with-settings")
////                        .getReturnItem(UserObjectResponse.class);
////        assertThat(userObjectResponse).isNotNull();
////    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20170711/webusers/{webuserId}/language")
////    @Step("Update")
////    @Issue("QC-85")
////    public void updatesWebUserLanguageForGivenWebuserId() {
////        userService.regWebuser(
////                v20170711, userId,
////                setupUserContextAsString
////        )
////                .path("/language")
////                .contentType("")
////                .body(LANGUAGE_DATA)
////                .put();
////    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20180507/webusers/{webuserId}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsUser() {
//        UserResponse userResponse =
//                userService.regWebuser(
//                        v20180507, userId,
//                        setupUserContextAsString
//                )
//                        .getReturnItem(UserResponse.class);
//        assertThat(userResponse).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers")
//    @Step("Get")
//    @Issue("QC-85")
//    public void findClientWebusersv20190111() {
//        Response response = userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .get();
//        assertThat(response).isNotNull();
//    }
//
//    @Test(dependsOnMethods = {"delete"})
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers")
//    @Step("Create")
//    @Issue("QC-85")
//    public void createv20190111() {
//        UserResponse userResponse = userService.reqClient(
//                v20190111, clientId,
//                setupUserContextAsString
//        )
//                .path("/webusers")
//                .body(USER_TEST)
//                .postReturnItem(UserResponse.class);
//        createdUserId = userResponse.getId();
//        assertThat(userResponse).isNotNull();
//
//    }
//
//    @Test(dependsOnMethods = {"createv20190111"})
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers/{webuserId}")
//    @Step("Delete")
//    @Issue("QC-85")
//    public void deletev20190111() {
//        userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .statusCode(HttpStatus.SC_NO_CONTENT)
//                .contentType("")
//                .delete();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers/{webuserId}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnWebuserByGivenWebuserIdv20190111() {
//        UserResponse response = userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers/{webuserId}")
//    @Step("Update")
//    @Issue("QC-85")
//    public void updateWebuserv20190111() {
//        UserResponse response = userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .body(USER_SETUP)
//                .putReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers/{webuserId}/regional-settings")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsRegionalDettingsForGivenWebuserIdv20190111() {
//        UserResponse response = userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .path("/regional-settings")
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/clients/{clientId}/webusers/{webuserId}/regional-settings")
//    @Step("Update")
//    @Issue("QC-85")
//    public void updateRegionalDettingsForGivenWebuserIdv20190111() {
//        UserResponse response = userService.reqClientWebuser(
//                v20190111, clientId, userId,
//                setupUserContextAsString
//        )
//                .path("/regional-settings")
//                .body(USER_SETUP)
//                .putReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/webusers")
//    @Step("Get")
//    @Issue("QC-85")
//    public void findWebusersv20190111() {
//        List<UserResponse> response = userService.regWebuser(v20190111, setupUserContextAsString)
//                .getReturnList(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/webusers/by-email-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByEmailAndPasswordv20190111() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("email", EMAIL);
//        queryparams.put("password", SETUP_USERNAME);
//        UserResponse response = userService.regWebuser(v20190111, setupUserContextAsString)
//                .path("/by-email-and-password")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20190111/webusers/by-email-verification")
////    @Step("Get user by confirming email")
////    @Issue("QC-85")
////    public void getByEmailVerification() {
////        UserResponse response = createSpecialTT2User();
////        Long newid = response.getId();
////        requestEmailConfirming(newid);
////        String emailVerificationUUID = databaseUser.getEmailVerificationUUID(newid);
////        UserResponse response2 = userService.regWebuser(v20190111, setupUserContextAsString)
////                .path("/by-email-verification")
////                .queryParameter("id", emailVerificationUUID)
////                .postReturnItem(UserResponse.class);
////        assertThat(response2).isNotNull();
////    }
//
////    @Step("request email confirming")
////    private void requestEmailConfirming(Long newid) {
////        userService.reqClientUser(
////                v20190108, clientId, newid,
////                setupUserContextAsString
////        )
////                .path("/email-change-requests")
////                .body(new EmailChangeRequest(EMAIL3))
////                .contentType("")
////                .post();
////    }
//
//    @Step("Create special tt2 user")
//    private UserResponse createSpecialTT2User() {
//        return userService.reqUserManagement(
//                v20200330, clientId, setupUserContextAsString)
//                .body(USER_EMAIL_VERIFICATION)
//                .postReturnItem(UserResponse.class);
//    }
//
////    @Test
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20190111/webusers/by-public-api-key/{keyString}")
////    @Step("Get")
////    @Issue("QC-85")
////    public void getByPublicApiKeyv20190111() {
////        String publicApiKey = userUtils.generatePublicApiKey(userId, setupUserContextAsString);
////        UserResponse response = userService.regWebuser(v20190111, setupUserContextAsString)
////                .path("/by-public-api-key/" + publicApiKey)
////                .getReturnItem(UserResponse.class);
////        assertThat(response).isNotNull();
////    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/webusers/by-username-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndPasswordv20190111() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("password", SETUP_USERNAME);
//        UserResponse response = userService.regWebuser(v20190111, setupUserContextAsString)
//                .path("/by-username-and-password")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/webusers/by-username-and-service-provider-id")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndServiceProviderIdv20190111() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("serviceProviderId", serviceProviderId);
//        UserResponse response = userService.regWebuser(v20190111, setupUserContextAsString)
//                .path("/by-username-and-service-provider-id")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190111/webusers/{webuserId}/regional-settings")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsRegionalSettingsForGivenWebuserIdv20190111() {
//        UserResponse response = userService.regWebuser(v20190111, userId, setupUserContextAsString)
//                .path("/regional-settings")
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/clients/{clientId}/objects/{objectId}/user-ids-by-object")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getsWebuserIdsByObjectIdv20190307() {
//        Response response = userService.reqClient(
//                v20190307, clientId,
//                setupUserContextAsString
//        )
//                .path("/objects/" + objectId + "/user-ids-by-object")
//                .get();
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/clients/{clientId}/users/{userId}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsUserByGivenClientIdAndUserId() {
//        UserResponse response = userService.reqClientUser(
//                v20190307, clientId, userId, setupUserContextAsString)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/by-email-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByEmailAndPasswordv20190307() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("email", EMAIL);
//        queryparams.put("password", USER_SETUP.getPassword());
//        UserResponse response = userService.reqUser(
//                v20190307, setupUserContextAsString)
//                .path("/by-email-and-password")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/by-email-and-password-and-service-provider-id")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByEmailAndPasswordAndServiceProviderId() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("email", EMAIL);
//        queryparams.put("password", SETUP_USERNAME);
//        queryparams.put("serviceProviderId", serviceProviderId);
//        UserResponse response = userService.reqUser(
//                v20190307, setupUserContextAsString)
//                .path("/by-email-and-password-and-service-provider-id")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/by-username-and-password")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndPasswordv20190307() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("password", SETUP_USERNAME);
//        UserResponse response = userService.reqUser(
//                v20190307, setupUserContextAsString)
//                .path("/by-username-and-password")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/by-username-and-password-and-service-provider-id")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getByUsernameAndPasswordAndServiceProviderIdv20190307() {
//        HashMap<String, Object> queryparams = new HashMap<>();
//        queryparams.put("username", SETUP_USERNAME);
//        queryparams.put("password", SETUP_USERNAME);
//        queryparams.put("serviceProviderId", serviceProviderId);
//        UserResponse response = userService.reqUser(
//                v20190307, setupUserContextAsString)
//                .path("/by-username-and-password-and-service-provider-id")
//                .queryParameters(queryparams)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/email/{email}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsUserByEmail() {
//        UserResponse response = userService.reqUser(
//                v20190307, setupUserContextAsString)
//                .path("/email/" + EMAIL)
//                .getReturnItem(UserResponse.class);
//        assertThat(response).isNotNull();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20190307/users/{userId}")
//    @Step("Get")
//    @Issue("QC-85")
//    public void returnsUserByGivenUserId() {
//        UserResponse userResponse =
//                userService.reqUser(v20190307, userId, setupUserContextAsString)
//                        .getReturnItem(UserResponse.class);
//        assertThat(userResponse).isNotNull();
//    }
}
