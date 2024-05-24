package com.example.praktika.response;

import com.example.praktika.entity.SummaryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    protected boolean success;
    protected String message;


}
