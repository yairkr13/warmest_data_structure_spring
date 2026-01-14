//  Part B
package warmest.controller;

import org.springframework.web.bind.annotation.*;
import warmest.service.WarmestService;
//Jason
@RestController
@RequestMapping("/warmest")  //netiv
public class WarmestController {

    private final WarmestService service;

    public WarmestController(WarmestService service) {
        this.service = service;
    }

    // PUT /warmest/put?key=a&value=100
    @PutMapping("/put")
    public Integer put(@RequestParam String key, @RequestParam int value) {
        return service.put(key, value);
    }

    // GET /warmest/get?key=a
    @GetMapping("/get")
    public Integer get(@RequestParam String key) {
        return service.get(key);
    }

    // DELETE /warmest/remove?key=a
    @DeleteMapping("/remove")
    public Integer remove(@RequestParam String key) {
        return service.remove(key);
    }

    // GET /warmest/warmest
    @GetMapping("/warmest")
    public String getWarmest() {
        return service.getWarmest();
    }
}