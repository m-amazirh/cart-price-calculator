package com.capco.customermanagement.domain.valueobject;

import com.capco.customermanagement.domain.exception.InvalidConsumerName;
import lombok.Data;
import lombok.NonNull;

@Data
public class ConsumerName {
    private final String firstName;
    private final String lastName;

    public ConsumerName(@NonNull String firstName, @NonNull String lastName){
        if(!isValid(firstName, lastName)){
            throw new InvalidConsumerName();
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullname(){
        return String.format("%s %s", firstName, lastName);
    }
    private boolean isValid(@NonNull String inputFirstName, @NonNull String inputLastName){
        return !inputFirstName.isBlank() && !inputLastName.isBlank();
    }
}
