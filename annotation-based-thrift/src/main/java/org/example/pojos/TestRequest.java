package org.example.pojos;

import com.facebook.drift.annotations.ThriftField;
import com.facebook.drift.annotations.ThriftStruct;
import lombok.Data;


@Data
@ThriftStruct
public class TestRequest {
    @ThriftField(value = 1)
    public Integer userid;
    @ThriftField(value = 2)
    public String message;
    @ThriftField(value = 3)
    public Integer seqid;
}
