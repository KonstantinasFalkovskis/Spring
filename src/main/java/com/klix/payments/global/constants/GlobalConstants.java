package com.klix.payments.global.constants;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class GlobalConstants {

    @Getter
    public enum GlobalLabels {
        STORE("demostore"),
        LOGIN("Login"),
        FILL_APPLICATION("Fill the application"),
        CHOOSE_OFFER("Choose an offer"),
        REVIEW("Review the loan agreement");

        private final String label;

        GlobalLabels(String label) {
            this.label = label;
        }


        @Override
        public String toString(){
            return label;
        }
    }

    @Getter
    public enum ArrayElements {
        FIRST(1),
        SECOND(2),
        THIRD(3),
        FOURTH(4);

        private final Integer value;

        ArrayElements(Integer value) {
            this.value = value;
        }
    }

    @Getter
    public enum ClassNames {
        LOGO("logo"),
        ADD_ITEM_TO_CART("add-to-cart clickable"),
        CART("full_cart"),
        TOTAL_COST("cart-summary-block-amount cart-item-bold"),
        CHECKOUT_BTN("cart-checkout-button"),
        KLIX_PAY_LATER_METHOD("klix-payment-method2"),
        MONTHS("open hydrated"),
        STEPS_HEADER("progress-bar-step-title"),
        CONTACT_DATA("contact-data-content"),
        COMPILE_OFFER("loading-offer-text");

        private final String className;

        ClassNames(String className) {
            this.className = className;
        }


        @Override
        public String toString() {
            return className;
        }
    }

    @Getter
    public enum Prices {
        EU_100("€100.00"),
        EU_55("€100.00"),
        EU_001("€0.01"),
        EU_349("€349.99");

        private final String price;

        Prices(String price) {
            this.price = price;
        }


        @Override
        public String toString() {
            return price;
        }
    }

    @Getter
    public enum Texts {
        CONTINUE("Continue"),
        CHOOSE_PAYMENT_METHOD("Choose payment method"),
        CALCULATION_DETAILS("Calculation details"),
        GET_OFFER("Get your offer"),
        NOT_POLITICALLY_EXPOSED_PERSON("I am not a politically exposed person"),
        POLITICALLY_EXPOSED_PERSON("I am a politically exposed person"),
        SALARY_AMOUNT("1000"),
        CREDIT_LIABILITIES("0"),
        MOCK_SMART_ID("Mock Smart-ID for testing purposes"),
        CHECKOUT("Checkout"),
        OK("Yes, all good"),
        COMPILE_BEST_OFFER("Compiling the best offers"),
        GET_AGREEMENT("Get agreement"),
        SIGN_LOAN_AGREEMENT("I have read and agree to sign the loan agreement."),
        SIGN_AGREEMENT_BUTTON("Sign the agreement");

        private final String text;

        Texts(String text) {
            this.text = text;
        }


        @Override
        public String toString() {
            return text;
        }
    }

    @Getter
    public enum OfferExamples {
        MON_1(1, "€100.00","€0","€132.28", "€3.70", "20.41%", "20%", "1 month"),
        MON_3(2, "€100.00","€3.00", "€103.00", "€33.34", "17.22%", "0%", "3 months"),
        MON_6(3, "€100.00","€5.00", "€105.00", "€16.67", "17.5%", "0%", "6 months"),
        MON_12(4, "€100.00","€7.00", "€107.00", "€8.34", "13.65%", "0%", "12 months"),
        MON_24(5, "€100.00","€10.00", "€110.00", "€4.17", "10.46%", "0%", "24 months");

        private final Integer value;
        private final String loanAmount;
        private final String agreementFee;
        private final String totalAmount;
        private final String monthlyAmount;
        private final String apr;
        private final String rate;
        private final String period;

        OfferExamples(Integer value, String loanAmount, String agreementFee, String totalAmount, String monthlyAmount, String apr, String rate, String period) {
            this.value = value;
            this.loanAmount = loanAmount;
            this.agreementFee = agreementFee;
            this.totalAmount = totalAmount;
            this.monthlyAmount = monthlyAmount;
            this.apr = apr;
            this.rate = rate;
            this.period = period;
        }

        @Override
        public String toString() {
            return "OfferExamples{" +
                    "loanAmount='" + loanAmount + '\'' +
                    ", agreementFee='" + agreementFee + '\'' +
                    ", totalAmount='" + totalAmount + '\'' +
                    ", monthlyAmount='" + monthlyAmount + '\'' +
                    ", apr='" + apr + '\'' +
                    ", rate='" + rate + '\'' +
                    ", period='" + period + '\'' +
                    '}';
        }
    }

    @Getter
    public enum Months {
        ONE_MONTH("1 mon"),
        THREE_MONTH("3 mon"),
        SIX_MONTH("6 mon"),
        TWELVE_MONTH("12 mon"),
        TWENTY_FOR_MONTH("24 mon");

        private final String month;

        Months(String month) {
            this.month = month;
        }


        @Override
        public String toString() {
            return month;
        }
    }

    @Getter
    public enum ElementNames {
        PERSONAL_CODE("person-code-input-Mock_Smart-ID"),
        PHONE("phoneNumber-Mock_Smart-ID"),
        NAME_SURNAME("userName");

        private final String elementNames;

        ElementNames(String elementNames) {
            this.elementNames = elementNames;
        }


        @Override
        public String toString() {
            return elementNames;
        }
    }

    @Getter
    public enum Users {
        USER_1("Janis Berzins","020659-14102", "26010000", "test.users@demostore.lv", "Riga", "Rigas str. 87", "LV-4366"),
        USER_2("Janis Berzins", "211111-333333", "26077777", "janis.berzins@example.com", "Riga", "Brīvības 12", "LV-1050");

        private final String name;
        private final String personalCode;
        private final String phone;
        private final String email;
        private final String city;
        private final String address;
        private final String zip;

        Users(String name, String personalCode, String phone, String email, String city, String address, String zip) {
            this.name = name;
            this.personalCode = personalCode;
            this.phone = phone;
            this.email = email;
            this.city = city;
            this.address = address;
            this.zip = zip;
        }

        @Override
        public String toString() {
            return "Users{" +
                    "name='" + name + '\'' +
                    ", personalCode='" + personalCode + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", city='" + city + '\'' +
                    ", address='" + address + '\'' +
                    ", zip='" + zip + '\'' +
                    '}';
        }

        @Getter
        public enum ElementId {
            PERSONAL_CODE("person-code-input-group-Mock_Smart-ID"),
            PHONE("phone-input-group-Mock_Smart-ID"),
            EMAIL("email"),
            CITY("city"),
            ADDRESS("addressLine"),
            ZIP("postalCode"),
            MARITAL_STATUS("#maritalStatus"),
            DEPENDENT_COUNT("#dependents"),
            INCOME_TYPE("#incomeType"),
            EMPLOYER_NAME("employerName"),
            MONTHLY_INCOME("monthlyIncome"),
            CREDIT_AMOUNT("monthlyCreditLiabilities"),
            PAYMENT_DATE("#monthlyPaymentDay"),
            CONFIRM_DATA_VALIDITY("agreeToTruthfulData"),
            CONFIRM_DATA_SHARE("agreeToDataSharingWithFinancingInstitutions"),
            CONFIRM_LETTERS("agreeToMarketing"),
            CONSENT_CHECKBOX("consent");

            private final String elementId;

            ElementId(String elementId) {
                this.elementId = elementId;
            }

            @Override
            public String toString() {
                return "ElementId{" +
                        "elementId='" + elementId + '\'' +
                        '}';
            }
        }

        @Getter
        public enum MaritalStatus {
            MARRIED("Married"),
            DIVORCED("Divorced"),
            SINGLE("Single"),
            WIDOW("Widower/Widow"),
            COHABITING("Cohabiting");

            private final String status;

            MaritalStatus(String status) {
                this.status = status;
            }

            @Override
            public String toString() {
                return "MaritalStatus{" +
                        "status='" + status + '\'' +
                        '}';
            }
        }

        @Getter
        public enum DependentCounts {
            NO_DEPENDENTS("No dependents");

            private final String dependents;

            DependentCounts(String dependents) {
                this.dependents = dependents;
            }

            @Override
            public String toString() {
                return "DependentCounts{" +
                        "dependents='" + dependents + '\'' +
                        '}';
            }
        }

        @Getter
        public enum IncomeTypes {
            SALARY("Salary"),
            PENSION("Pension"),
            ECONOMIC_ACTIVITIES("Income from economic activities");

            private final String incomes;

            IncomeTypes(String incomes) {
                this.incomes = incomes;
            }

            @Override
            public String toString() {
                return "IncomeTypes{" +
                        "incomes='" + incomes + '\'' +
                        '}';
            }
        }

        @Getter
        public enum PaymentDates {
            FIRST("1"),
            FIFTH("5"),
            TENTH("10"),
            FIFTEENTH("15"),
            TWENTIETH("20");

            private final String dates;

            PaymentDates(String dates) {
                this.dates = dates;
            }

            @Override
            public String toString() {
                return "PaymentDates{" +
                        "dates='" + dates + '\'' +
                        '}';
            }
        }
    }
}
