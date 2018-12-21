import avro.schema
from avro.datafile import DataFileWriter
from avro.io import DatumWriter
import csv
import calendar
import time



schema = avro.schema.parse(open("bagmd.avsc").read())

writer_null = DataFileWriter(open("bagmd_data_null_3.avro", "wb"), DatumWriter(), schema, codec="null")
writer_deflate = DataFileWriter(open("bagmd_data_deflate_3.avro", "wb"), DatumWriter(), schema, codec="deflate")


 
fields = "path version duration start end size messages compression vehicle error md5 types topics".split()
headers = dict([(v,i) for i,v in enumerate(fields)])



with open("./../../data/bagmd.data") as csvfile:
    reader = csv.reader(csvfile)
    reader.next() # skip header
    for boring_row in reader:

	print fields

        row = dict(zip(fields, boring_row))
        
        topics = ['t1', 't2', 't3']
        types = ['abc', 'def', 'ghi']
        
        row['types'] = types
        row['topics'] = topics
        
	print row

        writer_null.append(row)
        writer_deflate.append(row)

writer_null.close()
writer_deflate.close()

