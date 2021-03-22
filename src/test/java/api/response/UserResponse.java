package api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends BaseResponse{

    private List<Users> users;

    @Getter
    @Setter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Users{
        private String id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        @Getter
        @Setter
        @ToString
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Address{
            private String street;
            private String suite;
            private String city;
            private String zipcode;
            private Geo geo;

            @Getter
            @Setter
            @ToString
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Geo{
                private String lat;
                private String lng;

            }


        }

        @Getter
        @Setter
        @ToString
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Company{
            private String name;
            private String catchPhrase;
            private String bs;

        }

    }


}
