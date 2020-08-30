# classFile
该文件夹包含了所有的类
```$xslt
ClassFile {
    u4  magic;
    u2  minor_version;
    u2  major_version;
    u2  constant_pool_count;
    constant_info   constant_pool[constant_pool_count]; // 注意这里有一个null
    u2  access_flags;
    u2  this_class;
    u2  super_class;
    u2  interface_count;
    u2  interfaces[interfaces_count]
    u2  fileds_count;
    filed_info  fields[fields_count];
    u2  methods_count;
    method_info methods[methods_count]
    u2  attributes_count;
    attribute_info  attributes[attributes_count]
}

```