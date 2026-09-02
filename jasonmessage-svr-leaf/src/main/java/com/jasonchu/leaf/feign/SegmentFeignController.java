package com.jasonchu.leaf.feign;

import com.jasonchu.api.feign.LeafFeignClient;
import com.jasonchu.leaf.common.Result;
import com.jasonchu.leaf.common.Status;
import com.jasonchu.leaf.exception.LeafServerException;
import com.jasonchu.leaf.exception.NoKeyException;
import com.jasonchu.leaf.service.SegmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class SegmentFeignController implements LeafFeignClient {

    private final SegmentService segmentService;

    public SegmentFeignController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @Override
    public ResponseEntity<Long> getSegmentID(String key) {
        return ResponseEntity.ok(get(key, segmentService.getId(key)));
    }


    private Long get(String key, Result id) {
        Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }
        result = id;
        if (Objects.equals(result.getStatus(), Status.EXCEPTION)) {
            throw new LeafServerException(result.toString());
        }
        return result.getId();
    }
}
