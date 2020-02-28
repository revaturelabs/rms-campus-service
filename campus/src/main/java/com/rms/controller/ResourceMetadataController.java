// package com.rms.controller;

// import com.rms.dao.ResourceMetadataDao;
// import com.rms.model.ResourceMetadata;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping(value = "/resourcemetadata")
// public class ResourceMetadataController {

//     @Autowired
//     ResourceMetadataDao rms;

//     @GetMapping("/{id}")
//     public ResourceMetadata findById(@PathVariable("id") int id) {
//         return rms.findById(id).get();
//     }
    
//     @PostMapping("/all")
//     public Iterable<ResourceMetadata> getAllResourceMetadatas() {
//         return rms.findAll();
//     }

//     @PostMapping
//     public String insert(@RequestBody ResourceMetadata r){
//         rms.save(r);
//         return "ResourceMetadata has been added";
//     }

//     @PutMapping("/updated")
//     public String update(@RequestBody ResourceMetadata r){
//         rms.save(r);
//         return "ResourceMetadata has been updated";
//     }

//     @DeleteMapping("/deleted")
//     public String delete(@RequestBody ResourceMetadata r) {
//         rms.delete(r);
//         return "ResourceMetadata has been deleted";
//     }
// }