model.object("in_model") {
    field 'field', model.string()
    field 'value', model.list(model.number())
}

model.object("regex_model") {
    field 'field', model.string()
    field 'value', model.string()
}

model.select("filter_model", ["regex_model", "in_model"])

model.object("root") {
    field 'name', model.string()
    field 'age', model.number()
    field 'filter', filter_model
}

model.root("root")