package trade.web.api.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trade.domain.TradeType;
import trade.web.api.dto.request.BidOrAskRequest;
import trade.web.api.dto.response.BidOrAskResponse;
import trade.web.api.dto.response.DeleteTradeResponse;
import trade.web.api.dto.response.FindByMemberAndPageResponse;
import trade.web.api.dto.response.FindByOrderAndAggreagationResponse;
import trade.web.api.dto.request.PatchTradeRequest;
import trade.web.api.dto.response.PatchTradeResponse;
import trade.web.api.dto.response.CollectionResponse;
import trade.web.api.dto.TradeDto;

@RestController
@RequestMapping("/api")
public class TradeController {

    /**
     * id로 단건 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/trades/{id}")
    public TradeDto findOne(@PathVariable("id") Long id) {
        //Trade trade = tradeService.findById(id);
        return new TradeDto();
    }

    /**
     * 전체 조회
     *
     * @return
     */
    @GetMapping("/trades")
    public CollectionResponse<ArrayList<TradeDto>> findAll() {
        //Trade trade = tradeService.findAll();
        return new CollectionResponse<ArrayList<TradeDto>>();
    }


    /**
     * 특정 맴버 시간기준 페이지 조회
     *
     * @param memberId
     * @param sortRule
     * @param limit
     * @param offset
     * @param tradeType
     * @return
     */
    @GetMapping("/members/{id}/trades")
    public CollectionResponse<ArrayList<FindByMemberAndPageResponse>> findByMemberAndPage(
        @PathVariable("id") Long memberId,
        @RequestParam(value = "sort", defaultValue = "time:asc") String sortRule,
        @RequestParam(value = "limit", defaultValue = "20") String limit,
        @RequestParam(value = "offset", defaultValue = "0") Integer offset,
        @RequestParam(value = "trade_type", defaultValue = "") TradeType tradeType) {

        return new CollectionResponse<>();
    }

    /**
     * 유효한 매수, 매도 호가 (가격, 개수)반환
     * @param orderId
     * @return
     */
    @GetMapping("/orders/{id}/trades")
    public CollectionResponse<ArrayList<FindByOrderAndAggreagationResponse>> findByOrderAndAggregation(
        @PathVariable("id") Long orderId) {

        return new CollectionResponse<>();
    }

    /**
     * 호가 등록(매도, 매수) 예약 개념은 없다고 가정.
     *
     * @param request
     * @return
     */
    @PostMapping("/trades")
    public ResponseEntity<BidOrAskResponse> bidOrAsk(@RequestBody @Valid BidOrAskRequest request) {
        //1. 매도 혹은 매수 인지 파악
        //2. 매도 혹은 매수 가능 여부 파악
        //3. 2. 에서 불가능 하다면 불가능 이유 return
        //4. 2. 에서 가능하다면 매도 혹은 매수 DB에 추가
        //5. 4. 매도, 매수 각각 거래 가능한 품목 등록 순서대로 검색 후 가능하면 거래 수행 후 로그로 남김
        return new ResponseEntity<BidOrAskResponse>(HttpStatus.OK);
    }


    /**
     * 호가 수정
     *
     * @param id
     * @param request
     * @return
     */
    @PatchMapping("/trades/{id}")
    public PatchTradeResponse patchTrade(@PathVariable("id") Long id,
        @RequestBody List<@Valid PatchTradeRequest> request) {
        //tradeService.overwriteTrade(request.toEntity);
        return new PatchTradeResponse();
    }

    /**
     * 호가 취소
     *
     * @param id
     * @return
     */
    @DeleteMapping("/trades/{id}")
    public DeleteTradeResponse deleteTrade(@PathVariable("id") Long id) {
        //Long deleteId = tradeService.delete(id);
        return new DeleteTradeResponse();
    }

}
