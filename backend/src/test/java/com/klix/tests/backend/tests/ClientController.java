package com.klix.tests.backend.tests;

import com.klix.tests.backend.config.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test(groups = {"userService"})
public class ClientController extends BaseTest {

//    private Long createdClientId;
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Create")
//    @Issue("QC-85")
//    public void createClient() {
//        ClientResponse clientResponse = userService.reqClient(v20160617)
//                .body(CLIENT_TEST)
//                .postReturnItem(ClientResponse.class);
//        createdClientId = clientResponse.getId();
//        assertThat(clientResponse.getId()).isNotZero();
//        assertThat(clientResponse.getCreatedAt()).isNotBlank();
//        assertThat(clientResponse.getUpdatedAt()).isNotBlank();
//        assertThat(clientResponse.getCompanyName()).isEqualTo(CLIENT_TEST.getCompanyName());
//        assertThat(clientResponse.getPaidToDatetime()).isEqualTo(CLIENT_TEST.getPaidToDatetime());
//        assertThat(clientResponse.getProviderId()).isEqualTo(CLIENT_TEST.getProviderId());
//        assertThat(clientResponse.getSmsLimit()).isEqualTo(CLIENT_TEST.getSmsLimit());
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Create")
//    @Issue("QC-85")
//    public void createClientBadBody() {
//        userService.reqClient(v20160617)
//                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
//                .body(CLIENT_BAD_REQUEST)
//                .post();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Create")
//    @Issue("QC-85")
//    public void createClientBadRequest() {
//        userService.reqClient(v20160617)
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .post();
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getClientById() {
//        ClientResponse clientResponse = userService.reqClient(v20160617, setupClient.getId())
//                .getReturnItem(ClientResponse.class);
//        assertThat(clientResponse.getId()).isNotZero();
//        assertThat(clientResponse.getId()).isEqualTo(setupClient.getId());
//        assertThat(clientResponse.getCreatedAt()).isNotBlank();
//        assertThat(clientResponse.getUpdatedAt()).isNotBlank();
//        assertThat(clientResponse.getCompanyName()).isEqualTo(CLIENT_SETUP.getCompanyName());
//        assertThat(clientResponse.getPaidToDatetime()).isEqualTo(CLIENT_SETUP.getPaidToDatetime());
//        assertThat(clientResponse.getProviderId()).isEqualTo(CLIENT_SETUP.getProviderId());
//        assertThat(clientResponse.getSmsLimit()).isEqualTo(CLIENT_SETUP.getSmsLimit());
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Find")
//    @Issue("QC-85")
//    public void findClientById() {
//        List<ClientResponse> clientResponses = userService.reqClient(v20160617)
//                .path("/by-ids")
//                .body("[" + setupClient.getId() + "]")
//                .postReturnList(ClientResponse.class);
//        assertThat(clientResponses.size()).isEqualTo(1);
//        ClientResponse clientResponse = clientResponses.get(0);
//        assertThat(clientResponse.getId()).isNotZero();
//        assertThat(clientResponse.getId()).isEqualTo(setupClient.getId());
//        assertThat(clientResponse.getCreatedAt()).isNotBlank();
//        assertThat(clientResponse.getUpdatedAt()).isNotBlank();
//        assertThat(clientResponse.getCompanyName()).isEqualTo(CLIENT_SETUP.getCompanyName());
//        assertThat(clientResponse.getPaidToDatetime()).isEqualTo(CLIENT_SETUP.getPaidToDatetime());
//        assertThat(clientResponse.getProviderId()).isEqualTo(CLIENT_SETUP.getProviderId());
//        assertThat(clientResponse.getSmsLimit()).isEqualTo(CLIENT_SETUP.getSmsLimit());
//    }
//
//    @Test
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Get")
//    @Issue("QC-85")
//    public void getClientByParameter() {
//        List<ClientResponse> clientResponse = userService.reqClient(v20160617)
//                //.path("/")
//                //.statusCode(3)
//                .queryParameter("providerId", CLIENT_BAD_REQUEST.getProviderId())
//                .getReturnList(ClientResponse.class);
//        ClientResponse clientResponseEdit = clientResponse.stream().filter(
//                c -> c.getId().equals(setupClient.getId())).findFirst().orElse(null);
//        System.out.println(setupClient.getId());
//        assertThat(clientResponseEdit.getId()).isNotZero();
//        assertThat(clientResponseEdit.getId()).isEqualTo(setupClient.getId());
//        assertThat(clientResponseEdit.getCreatedAt()).isNotBlank();
//        assertThat(clientResponseEdit.getUpdatedAt()).isNotBlank();
//        assertThat(clientResponseEdit.getCompanyName()).isEqualTo(CLIENT_SETUP.getCompanyName());
//        assertThat(clientResponseEdit.getPaidToDatetime()).isEqualTo(CLIENT_SETUP.getPaidToDatetime());
//        assertThat(clientResponseEdit.getProviderId()).isEqualTo(CLIENT_SETUP.getProviderId());
//        assertThat(clientResponseEdit.getSmsLimit()).isEqualTo(CLIENT_SETUP.getSmsLimit());
//    }
//
////    @Test(dependsOnMethods = {"createClient"})
////    @Severity(SeverityLevel.BLOCKER)
////    @Description("/v20160617/clients")
////    @Step("Update")
////    @Issue("QC-85")
////    public void updateClient() {
////        ClientRequest updateBody = cloneObjectSerialize(CLIENT_SETUP, ClientRequest.class);
////        updateBody.setId(setupClient.getId());
////        ClientResponse clientResponse = userService.reqClient(v20160617, setupClient.getId())
////                .body(updateBody)
////                .putReturnItem(ClientResponse.class);
////        assertThat(clientResponse.getId()).isNotNull().isNotZero();
////        assertThat(clientResponse.getId()).isEqualTo(setupClient.getId());
////        //assertThat(client.getCreatedAt()).isNotBlank();
////        assertThat(clientResponse.getUpdatedAt()).isNotBlank();
////        assertThat(clientResponse.getCompanyName()).isEqualTo(CLIENT_SETUP.getCompanyName());
////        assertThat(clientResponse.getPaidToDatetime()).isEqualTo(CLIENT_SETUP.getPaidToDatetime());
////        assertThat(clientResponse.getProviderId()).isEqualTo(CLIENT_SETUP.getProviderId());
////        assertThat(clientResponse.getSmsLimit()).isEqualTo(CLIENT_SETUP.getSmsLimit());
////    }
//
//    @Test(dependsOnMethods = {"createClient"})
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("/v20160617/clients")
//    @Step("Delete")
//    @Issue("QC-85")
//    public void deleteClient() {
//        userService.reqClient(v20160617, createdClientId)
//                .statusCode(HttpStatus.SC_NO_CONTENT)
//                .contentType("")
//                .delete();
//    }
}
