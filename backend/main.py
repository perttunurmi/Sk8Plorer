from fastapi import FastAPI
from database import engine

app = FastAPI()

@app.get("/")
async def root():
    try:
        conn = engine.connect()
        conn.close()
        return {"message": "Database connected!"}
    except Exception as e:
        return {"error": str(e)}